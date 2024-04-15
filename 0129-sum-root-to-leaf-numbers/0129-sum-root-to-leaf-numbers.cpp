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
    int ans = 0;
    void solve(TreeNode* root, int temp){
        if(root==NULL)return;
        if(root->left==NULL && root->right==NULL){
            ans+=(temp*10)+(root->val);
            return;
        }
        solve(root->left , ((temp*10)+(root->val)));
        solve(root->right , ((temp*10)+(root->val)));
    }
    int sumNumbers(TreeNode* root) {
        solve(root,0);
        return ans;
    }
};