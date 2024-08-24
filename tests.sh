#!/bin/bash
# Run the tests
mvn clean test -Dtest=SearchTests -DsureFire.useFile=true

# Save the exit code
exit_code=$?

# Reset the current commit, to undo the changes made during tests
git reset --hard


# Exit with a non-zero exit code if any of the tests fail
if [ $exit_code -ne 0 ]; 
then
  exit 1
fi

# Exit with a zero exit code if the tests succeed
exit 0
