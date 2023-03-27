#!/bin/bash

# Define variables
commit_message=$1
branch_name=$(git branch --show-current)

# Display current Git status
echo "Current Git status:"
git status

# Prompt user to enter commit message
read -p "Enter commit message: " commit_message

# Commit changes
echo "Committing changes..."
git add .
git commit -m "$commit_message"

# Push changes to remote repository
echo "Pushing changes to $branch_name branch..."
git push origin $branch_name
