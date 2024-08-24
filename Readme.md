
# Automate Git Bisect Process

In this project, you'll learn about a crucial command provided by Git for the smooth detection of errors in an application: the `git bisect` command. This command helps developers find the specific commit that introduced a bug in their codebase.

## Overview

To demonstrate this process, we’ve provided a GitHub repository with a series of commits, including an error that has been introduced to make it a practical use case. You can explore the code in the `/usercode/spagitbisect/` directory.

### Code Structure

- **`/usercode/spagitbisect/src/main/java/org/example/Search.java`**  
  This file contains a basic implementation of the exponential search algorithm.

- **`/usercode/spagitbisect/src/test/java/SearchTests.java`**  
  This file contains the test cases that validate the search algorithm's functionality.

## Running the Tests

To verify that some test cases are failing in the most recent commit, run the tests available in the `/usercode/spagitbisect/src/test/java/SearchTests.java` file. Use the following command to run the tests:

```base
cd /usercode/spagitbisect/
# Command to run the tests (adjust this according to your testing framework)
```
```cmd
mvn clean test -Dtest=SearchTests -Dsurefire.useFile=true 
```


### Identifying the good commit 

- Verify that the `42eee8d` commit is a good commit. 
- before running this git cmd, make sure to commit your changes & trigger 

```
git checkout 42eee8d
```
- run the test case using the same command 
```cmd
mvn clean test -Dtest=SearchTests -Dsurefire.useFile=true 
```
- And this time its `Build success`

HINT : you can also check your commits in petty format 
```
git log --pretty=format:"%h %cd"
```

- Lets investigate the where the bug introduced,
```
git bisect bad <commit>
``` 
- found that from commit `8606962`, the bug got introduced.
- lets start the `bisect`
```
git bisect start
```
- with `git status`, you we can see that 
- __You are currently bisecting, started from branch '8606962'.__

- Now, we have to find between root issue good commit `42eee8d` & bad commit `8606962`
- Starting from good commit `42eee8d`, we have to mark subsequent till recent commit as good/bad using 
```
git bisect good/bad <commit>
```

- If you have many commits, it can become difficult to keep track of which ones have already been determined to be good or bad. Therefore, while you're marking the commits as good or bad, Git offers you a command to keep track of the examined commits and another command to check the current status of the process.

- we can use, to check the already marked good/bad commit labels
```
git bisect log
```

- and To see the current status of the git bisect process, 
```
git bisect view
```

- Hmm, its hard to perform this steps manually right, lets automate this using  bash script `test.sh`

- How this `test.sh` works, we know that the bug is introduces between the commits good commit`42eee8d` & bad commit `8606962`
- The scripts triggers all the testcases between these commits & if the tests are failed inbetween this commits, Tadda that's the commit where the bug was introduced 
- lets setup the things, so that bash script works properly, 
 ```
- First, Reset the git bisect using
`git bisect reset`
- Reset all the changes in the main branch, 
`git reset --hard`
- Start the git bisect process again by running
`git bisect start`
-Mark the first good commit by running the following command, 
`git bisect good 42eee8d`
-  Mark the bad commit by running the following command
`git bisect bad 8606962`
- Run the script
`git bisect run /test.sh`
 ```
- In our case, its 
```
HEAD is now at 5e9b314 separated binary search implementation
2ce44cd4a3dc1992d1febbea348c3255c954cf45 is the first bad commit
commit 2ce44cd4a3dc1992d1febbea348c3255c954cf45
Author: CourseMaterial <admin_external_service@educative.io>
Date:   Mon Mar 13 15:10:16 2023 +0500
```