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
    void solve(TreeNode* root , vector<int>&count){
        if(root == NULL)return;
        count[root->val]++;
        if(root->left ==NULL && root->right ==NULL){
            int temp = 0;
            for(int x : count)if(x&1)temp++;
            count[root->val]--;
            if(temp<=1)ans++;
            return;
        }
        solve(root->left , count);
        solve(root->right , count);
        count[root->val]--;   
    }
    int pseudoPalindromicPaths (TreeNode* root) {
        vector<int>count(10,0);
        solve(root,count);
        return ans;
    }
};