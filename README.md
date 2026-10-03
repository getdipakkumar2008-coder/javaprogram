# javaprogram

## Banking program

A beginner-friendly console program for one account, starting with a balance of
`0.0`. It uses only standard Java and requires Java 14 or newer for the enhanced
`switch` statement.

Compile and run from the repository directory:

```sh
javac BankingProgram.java
java BankingProgram
```

Choose **1** to show the balance, **2** to deposit, **3** to withdraw, or **4** to
exit. Balances display two decimal places. Invalid menu selections and amounts
leave the balance unchanged; negative amounts and overdrafts are rejected.
Nonnumeric or non-finite amounts are also rejected, as are deposits that would
overflow the balance. End-of-input exits cleanly.

### How it works

- The `while` loop repeats the menu while `isRunning` is true.
- The enhanced `switch` selects the action; option 4 sets `isRunning` to false.
- Methods are `static` so `main` can call them without creating an account object.
- `deposit()` returns the valid amount to add to the balance, or `0` on rejection.
- `withdraw(balance)` returns the amount to subtract only if it is nonnegative
  and no greater than the current balance; otherwise it returns `0`.
- One class-level `Scanner` is shared by `main`, `deposit`, and `withdraw`, and
  is closed when the program exits.