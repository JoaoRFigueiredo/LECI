# Aula01 - Notes

---

## Exercise 1 - Word Search Solver

First exercise is pretty straigth forward, our WSSolver.java has to solve a Word puzzle, by highlighting the target words in the matrix.

**Requirements**:
   - An input file must be provided, which will contain the word puzzle and a list of target words.
   - The word puzzle must be squared and must only contain Upper-case letters.
   - The list of target words can be identified by words written in lower-case or a mix between upper and lower-case letters. Every word is separed by white spaces, semicolons, commas or lines.
   - Here's an example:

``` text
    STACKJCPAXLF
    YLKWUGGTESTL
    LNJSUNCUXZPD
    ETOFQIKICFNG
    SENILMJFUMRK
    ZBUUOMSBSKCY
    SUMTRASARZIX
    RBMWWRJDAXVF
    JEJHQGSDRAIB
    ACWEZOLMZOLT
    VIUQVRAMDGWH
    AGFTWPJZWUMH
    programming;java;words lines civil
    test;stack;
```


**Result**
- The result must be placed in a file. Here's an example:

```text
programming  11    (12, 6)   Up       
java         4     (9, 1)    Down     
words        5     (11, 11)  Up-left  
lines        5     (5, 5)    Left     
civil        5     (6, 11)   Down     
test         4     (2, 8)    Right    
stack        5     (1, 1)    Right    

STACK.......
.....G.TEST.
.....N......
.....I......
SENILM......
.....M....C.
.....AS...I.
.....R.D..V.
J....G..R.I.
A....O...OL.
V....R....W.
A....P......
```

---

## Exercise 2 - Word Search Generator

This exercise is also pretty straight-forward. The goal is to generate a word puzzle with a list of words, which is provided beforehand.

**Requirements**:
- A file with the list of words must provided.
- If a line contains multiple words, they will separed by white spaces, commas or semicollons or there can a word per line.
- Words in the list must be lower-case only or a mix of lower and upper-case.

**Execution and Ouputs**

Two diferent outputs are expected, according to the arguments provided:

- ```java WSGenerator.java -i wordlist.txt -s 15 ```

```text
WLNDUIOVLBOKXZJ
QFHYDSKMHPRSACY
UGMNFSAQBLPHMYG
AYTHGKLJTRSMKJR
NTFLHHBFAWWDBRQ
TTBCDJGYXKIJFQO
IPTUEIBRCAEYVEZ
TOPJJSBBFOBHXBP
YWVVERSASOAQNLF
VSTATERNISUOCTI
REFERRALTTDGSBN
KZWKYRSBFIJMZTD
BCEREMONYLYJYPO
JSOSJYLJAFUTVPO
BSGBEPOMMNDZVVR
ceremony
quantity
cousin
referral
tax
indoor
aid
state
```

- ```java WSGenerator.java -i wordlist.txt -s 15 -o wordlist_solved.txt```

```text
ceremony        8     (13, 2)   Right    
quantity        8     (2, 1)    Down     
cousin          6     (10, 13)  Left     
referral        8     (11, 1)   Right    
tax             3     (4, 9)    Down     
indoor          6     (10, 15)  Down     
aid             3     (7, 10)   Up-right 
state           5     (10, 2)   Right    

WLNDUIOVLBOKXZJ
QFHYDSKMHPRSACY
UGMNFSAQBLPHMYG
AYTHGKLJTRSMKJR
NTFLHHBFAWWDBRQ
TTBCDJGYXKIJFQO
IPTUEIBRCAEYVEZ
TOPJJSBBFOBHXBP
YWVVERSASOAQNLF
VSTATERNISUOCTI
REFERRALTTDGSBN
KZWKYRSBFIJMZTD
BCEREMONYLYJYPO
JSOSJYLJAFUTVPO
BSGBEPOMMNDZVVR
```
 


