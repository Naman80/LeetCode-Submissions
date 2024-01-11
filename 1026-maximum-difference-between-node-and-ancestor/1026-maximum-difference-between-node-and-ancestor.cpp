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
        solve(root);
        return ans;
    }
    
    pair<int ,int> solve(TreeNode * root){
        if(root==NULL){
            return {INT_MAX ,INT_MIN};
        }
        if(root->left ==NULL && root->right ==NULL)return{root->val , root->val};
        auto left = solve(root->left);
        auto right = solve(root->right);
        int mn = min(left.first , right.first);
        int mx = max(left.second, right.second);
        int diff = max(abs(mn - root->val) , abs(mx - root->val));
        ans = max(ans , diff);
        return {min(root->val , mn) , max(root->val , mx)};
    }
    
};