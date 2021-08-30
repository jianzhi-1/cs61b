# CS61B
### UC Berkeley Fall 2021, taught by Prof Hilfinger
This repository is meant to store my lecture/discussion notes, which I think would be nice to share with my peers. I will **not** be uploading anything related to homework or assignments. Please contact me if you feel any file should not be here. Thanks!

### Some checks before submitting HW
- ```/** Documentation comments */```
- Do not use ```//``` for comments

### Testing on Instructional Account
SSH into remote computer, change directory to repo (only repo is git initiated). Pull all the changes made from local, then test.
After testing, check git status, then tag it with labx-y where x is the lab number and y is the attempt number. Push both.

```shell
$ ssh cs61b-***@derby.cs.berkeley.edu
$ cd repo
$ git pull

$ git status
$ git tag lab1-0
$ git push
$ git push --tags
```

### Receiving and Submitting HW
```shell
$ cd repo
$ git fetch shared
$ git merge -m "Start Lab 1" shared/lab1 --allow-unrelated-histories
$ git push
```



### Access Permissions
- Public: can be referred to anywhere in the program. 
- Private: makes access illegal
- Static: (opposite to static is instance)

### Grading
- Tests (40%)
- Projects (50%)
- HW (10%)
- Course is not curved


