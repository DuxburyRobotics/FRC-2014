# READ ME

## Source code for 2014 Duxbury FRC Competition

GIT Workflow

The following commands should be entered into
the GIT Bash program.
Anything inside of <> (ie <branch_name>) is a custom string.

### UPDATE: always branch from the develop branch! Never commit the master branch and only commit to the develop branch when the whole team has agreed
that it is stable!

#### Getting the latest version of the stable code for the first time:

	Clone the repository into an empty directory:

		Create an empty folder somewhere on your computer

			- cd <new folder>
			- git clone https://<your bitbucket username>@bitbucket.org/duxburyrobotics/frc-2014.git
			- cd frc-2014

#### To obtain the latest version of the code and update your local copy:

			- cd <directory that contains GIT repo>
			- cd first-robotics
			- git remote update
			- git pull

		The Net Beans project must then be refreshed. Do so by right clicking on the project folder in Eclipse and choosing Refresh.

#### Editing the source

	A new branch must be created. This allows the changed code to be reviewed and to not overwrite the existing, stable build:
		On bitbucket.com, click on the branches tab. Create a new branch named <branch_name>.
		Copy the command that it generates into GIT Bash
		Make all changes to code. All work should be done inside of that branch until a stable base is created. Only then should the changes be committed to the repository.
		**bold** The master branch should never be committed to! **bold**
		Commit descriptions should be brief but informative. Please try to always include one.

			- git add .
			- git commit -m "Commit message describing changes"
			- git push -u origin <branch_name>

		The commit will be reviewed and merged with the main branch later
		Once you are done editing the code, delete the local branch.

			- git branch -D <branch_name>

#### Viewing GIT status

	The status of the GIT repo can be viewed with the following command:

		- git status

	This will show files that are being tracked by the repository that have been edited, added, or removed. If the files are red, they needed to be added. They can be added individually by using this command:

		- git add <file name>

	But it is easier to use this command if a large amount of files need to be added:

		- git add .

	Files that are deleted locally must be deleted from the GIT repo. Do so with this command:

		- git rm <file name>

	Once all files have been properly added and removed, it is wise to check the status and make sure all statuses are green and able to be committed.