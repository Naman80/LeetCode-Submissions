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
    int ans = -1;
    int maxAncestorDiff(TreeNode* root) {
        solve(root , root->val , root->val);
        return ans;
    }
    
    void solve(TreeNode * root , int mn , int mx){
        ans = max(ans , mx - mn);
        if(root==NULL)return;
        solve(root->left , min(mn , root->val) , max(mx , root->val));
        solve(root->right , min(mn , root->val) , max(mx , root->val));
    }
    
};