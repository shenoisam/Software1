#!/bin/bash 

# Author: Sam Shenoi 
# Description: This program defines a pre-push hook that runs all of the previously made JUnit tests in order to ensure that everything works. 
# This program calls each test in the test directory in order to accomplish this


# To skip this and push anyway despite failing tests, run the following command 
# git commit --no-verify -m <Your message> 

# For now since there are no tests, we will use the test script in the test folder 
./src/test/testscript.sh


# If the last value returned an error, we arent ready to push 
if [ $? -ne 0 ] 
then
       echo "Test failed, please check before commit" 
       exit 1 
fi 

