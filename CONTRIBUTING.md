
### Git workflow
Always make a new branch of the up to date "development" branch for each issue you working on. 
The conventional way to name your branch is to put the issue number before the name of the branch. 
For example, if you work on issue #100, the branch should be #100_my_branch.
  
Never work on development branch! If you accidentaly work on it, stash you changes and move to another branch.
  
Never work on more than one issue in the same branch. 
You shouldn't be fixing issue #100 and issue #101 in the "issue100" branch. Reject the PR if you see it happens.
  
When working on one issue, it might take a day or two to finish. To keep track of your progress, always reference the issue in the commit message
   
When you are done with the implementaion details required by the issue do not make a PR right away. 
Look through the changes you made and make a self review. When you feel ready create a Pull request. 
Wait for any changes request from code reviewers. 
After you get at least two green signal, take a look to other pull request and make merge strategy, avoid merging the same things twice.
When you decide to merge the pull request, merge it and delete the branch. 
  
### Commit message
1.Always write a comment when committing something to the repository. Avoid the messages of the type: fixes, merges, no comment etc
2.The comment should be brief and to the point
3.The comment should be in past simple tense
4.If you made several changes, separate the changes in different sentances.
5.Always prefixing your comment with issue number wrapped in square brackets ([#issueNumber]). If there is not an issue, prefix the comment with [no-issue]. 
For example [#issueNumber]-Implemented commit message guideline
 
### Code review
Code reviewing is very important! You need to make sure that you're fully understand about the changes were made. 
Check for error, insufficient code, code styling and make appropriate change requests. 
When you are requesting some changeses always provide a reason why the changes should be made, it is a good approuch of knowledge sharing
  
 ### Protect development branch
Because the repository has multiple collaborators, we should protect the development branch from irrevocable changes.
Protected branches block several features of Git on a branch that a repository administrator chooses to protect. A protected branch:
- Can't be force pushed
- Can't be deleted
- Can't have changes merged into it until required status checks pass
- Can't have changes merged into it until required reviews are approved
- Can't be edited or have files uploaded to it from the web
