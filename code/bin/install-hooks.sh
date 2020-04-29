#!/bin/bash 


GIT_DIR=$(git rev-parse --git-dir) 

echo "Installing hooks..."
# Create a symlink to pre-commit script 
ln -s $(pwd)/pre-push.sh $GIT_DIR/hooks/pre-push

echo "Installed!" 
