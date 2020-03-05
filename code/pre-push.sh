# Author: Sam Shenoi 
# Description: This program runs the pre-push hook which runs a suite of tests before a push can be committed. 


# To escape this and push anyway, please run this command
# git commit --no-verify -m <Your message> 



# For now lets run a sample script in the test folder 

dirPath=$(pwd)
$dirPath/code/src/test/testscript.sh 


# Check to see if the last result worked properly

if [ $? -ne 0 ] 
then 
	echo "Test failed, please fix before pushing"
        exit 1 
fi 

