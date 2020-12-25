class Solution {
public:
    vector<int> findDiagonalOrder(vector<vector<int>>& matrix) {
        // declare vector we will return at the end
        vector<int> result;
        // manage base case of when matrix is empty
        if (matrix.size() == 0) return result;
        
        // variables for storing the last index for rows and columns
        int iIndex = matrix.size() - 1, jIndex = matrix[0].size() - 1;
        // variables for storing the current index while traversing the matrix
        int i = 0, j = 0;
        // variable to check which direction we are moving
        bool isMovingUpRight = true;
        
        // push the first element into the result vector
        result.push_back(matrix[i][j]);
        
        // while we have not reach the end of the row and column (last index for both row and column)
        while (i != iIndex || j != jIndex) {
            if (isMovingUpRight) { // if we are moving in the up-right direction...
                if (j == jIndex) { // ...and we have hit the right end of the matrix, we will move down one position and switch direction
                    i++;
                    isMovingUpRight = false;
                } else if (i == 0) { // ...and we have hit the top the matrix, we will move right one position and switch direction
                    j++;
                    isMovingUpRight = false;
                } else { // ...else we have not hit the end of either side so we will move up and right one position
                    i--;
                    j++;
                }
            } else { // else we are moving in the bottom-left direction...
                if (i == iIndex) { // ...and we have hit the bottom of the matrix, we will move right one position and switch direction
                    j++;
                    isMovingUpRight = true;
                } else if (j == 0) { // ...and we have hit the left end of the matrix, we will move down and switch direction
                    i++;
                    isMovingUpRight = true;
                } else { // ...else we have not hit the end of either side so we will move down and left one position
                    i++;
                    j--;
                }
            }
            
            result.push_back(matrix[i][j]); // after moving, we will push the current element into the result vector
        }
        
        return result; // return final result after traversing the matrix
    }
};
