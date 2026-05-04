# 👑 Hard Problem? Nah… Let’s Make It EASY 💀 || JAVA || Simple yet Optimal 💡

## 🧠 Intuition

Bhai tera code already solid hai 🔥
Tu kya kar raha hai:

👉 Har number ko uske **sign (+/-)** ke saath `res` me add kar raha hai
👉 Jab `(` aata hai → tu **current state (res + sign)** stack me store karta hai
👉 Jab `)` aata hai → tu **andar ka result nikaal ke bahar wale context se merge karta hai**

👉 Matlab:

> **Stack = memory of previous calculation state**

---

## 🔍 Visualization

### 📌 Case: `"1 + (2 - 3)"`

![Image](https://images.openai.com/static-rsc-4/aOZ5h65LP4QWp5Gc7iZM0cyacDvacq8FaelLToqI7x-nMt9l6eZQkKzxnysyUS7UEh4DrulPUWsdi750qSdYUmbujIMkUdNjyxnR5Om_f-OUosrhTcE4TWv2fqjcvRwswe4LQB2S05rAc6DGj2BNqhFLHbFXIdaTn28qASBulTV3IUmc6SoIWg4_GMFCak6u?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/XJiZveXcBjhsalE5ZqP1msIACdqcRg4aY3xrePpiiHUbi6jQLkPqRUVx408mlqjUJk9WC5GNucjEFFPb4EP85J_ZTuFfH867WkZBzSm_T9_zyOg8zPPVp1vobZ2qIyHKjEeyBGK7iC93AstHu0LpyLqHj6lk70BRHznFFgyOYeSS8x9u5B65GnmgDBS1DlLb?purpose=fullsize)

![Image](https://images.openai.com/static-rsc-4/DbJsON5tGbYkz5WxSPouoNq4JqH9C1AAgv893ZeViedtbERy2D7LoKQTPTIb9rxJSiFzDWDjzUgqbSE-ALAtM1i25eOw678EaDOkBbDDIG_xL1U2XCU07ukwvCP2qReC5O0wG7wdrD6p3dhocxhHvVFXF7LCYwBnZ_Qi0D7ELyZdqA655FHmrpVCpro8jDwJ?purpose=fullsize)


### 🪜 Step Flow:

| Step | Char | Action         | Stack   | res                 |
| ---- | ---- | -------------- | ------- | ------------------- |
| 1    | '1'  | num = 1        | []      | 0                   |
| 2    | '+'  | res += 1       | []      | 1                   |
| 3    | '('  | push res, sign | [1, +1] | 0                   |
| 4    | '2'  | num = 2        | [1, +1] | 0                   |
| 5    | '-'  | res += 2       | [1, +1] | 2                   |
| 6    | '3'  | num = 3        | [1, +1] | 2                   |
| 7    | ')'  | resolve inside | []      | (2-3) = -1 → +1 = 0 |

---

## ⚙️ Approach 

### 🔹 1. Number build karna

```java
num = num * 10 + digit;
```

---

### 🔹 2. '+' ya '-' aaye

```java
res += num * sign;
num = 0;
sign = +1 / -1;
```

---

### 🔹 3. '(' aaye → context save

```java
st.push(res);
st.push(sign);

res = 0;
sign = 1;
```

👉 Fresh calculation start (andar ka expression)

---

### 🔹 4. ')' aaye → context restore

```java
res += num * sign;

int st_sign = st.pop();
int st_res = st.pop();

res = res * st_sign + st_res;
```

👉 Inner result ko outer se jod diya 🔥

---

### 🔹 5. End me last number add

```java
res += num * sign;
```

---

## ⚡ Complexity

* **Time complexity:** `O(n)`
* **Space complexity:** `O(n)` (stack use ho raha hai)

---

## 💻 Code  
```java []
class Solution {
    public int calculate(String s) {
        int n = s.length();
        Stack<Integer> st = new Stack<>();

        int num = 0;
        int res = 0;
        int sign = 1;

        for(int i = 0; i < n; i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
            }
            else if(s.charAt(i) == '+'){
                res += num * sign;
                num = 0;
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                res += num * sign;
                num = 0;
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                num = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                res += num * sign;
                num = 0;

                int st_sign = st.pop();
                int st_res = st.pop();

                res *= st_sign;
                res += st_res;
            }
        }

        res += num * sign;
        return res;
    }
}
```
```python []
class Solution:
    def calculate(self, s: str) -> int:
        stack = []
        num = 0
        res = 0
        sign = 1

        for ch in s:
            if ch.isdigit():
                num = num * 10 + int(ch)

            elif ch == '+':
                res += num * sign
                num = 0
                sign = 1

            elif ch == '-':
                res += num * sign
                num = 0
                sign = -1

            elif ch == '(':
                stack.append(res)
                stack.append(sign)
                res = 0
                sign = 1

            elif ch == ')':
                res += num * sign
                num = 0

                st_sign = stack.pop()
                st_res = stack.pop()

                res = res * st_sign + st_res

        res += num * sign
        return res
```
```C++ []
class Solution {
public:
    int calculate(string s) {
        stack<int> st;
        int num = 0, res = 0, sign = 1;

        for(char ch : s){
            if(isdigit(ch)){
                num = num * 10 + (ch - '0');
            }
            else if(ch == '+'){
                res += num * sign;
                num = 0;
                sign = 1;
            }
            else if(ch == '-'){
                res += num * sign;
                num = 0;
                sign = -1;
            }
            else if(ch == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }
            else if(ch == ')'){
                res += num * sign;
                num = 0;

                int st_sign = st.top(); st.pop();
                int st_res = st.top(); st.pop();

                res = res * st_sign + st_res;
            }
        }

        res += num * sign;
        return res;
    }
};
```
``` C []
#include <stdio.h>
#include <ctype.h>

int calculate(char* s) {
    int stack[10000];
    int top = -1;

    int num = 0, res = 0, sign = 1;

    for(int i = 0; s[i] != '\0'; i++){
        char ch = s[i];

        if(isdigit(ch)){
            num = num * 10 + (ch - '0');
        }
        else if(ch == '+'){
            res += num * sign;
            num = 0;
            sign = 1;
        }
        else if(ch == '-'){
            res += num * sign;
            num = 0;
            sign = -1;
        }
        else if(ch == '('){
            stack[++top] = res;
            stack[++top] = sign;
            res = 0;
            sign = 1;
        }
        else if(ch == ')'){
            res += num * sign;
            num = 0;

            int st_sign = stack[top--];
            int st_res = stack[top--];

            res = res * st_sign + st_res;
        }
    }

    res += num * sign;
    return res;
}
```




---

## 🔥 **Bhai Level Takeaways**

✔ Tu **operator precedence handle nahi kar raha — sirf + - hai → easy**
✔ Stack me tu **previous world save kar raha hai (res + sign)**
✔ `(` = new world 🌍
✔ `)` = back to old world 🔙


