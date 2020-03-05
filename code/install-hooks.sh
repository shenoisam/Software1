#!/bin/bash 

GIT_DIR="../.git"

echo "Installing hooks..."

# Create a symlink to pre-commit script 
ln -s ../code/pre-push.sh $GIT_DIR/hooks/pre-push
