/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int rangeSumBST(TreeNode* root, int low, int high) {
        if(root == NULL)return 0;
        int val = root -> val;
        if(val > high)return rangeSumBST(root->left , low , high);
        if( val < low)return rangeSumBST(root->right , low, high);
        int left = 0;
        int right = 0 ;
        left += rangeSumBST(root->left , low , high);
        right += rangeSumBST(root->right , low, high);
        return left + right + val;
    }
};