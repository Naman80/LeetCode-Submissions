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
    
    void store(TreeNode* root , vector<int>& leafs){
        if(root == NULL)return;
        if(root->left ==NULL&& root->right==NULL){
            leafs.push_back(root->val);return;
        }
        store(root->left , leafs);
        store(root -> right , leafs);
    }
    
    bool leafSimilar(TreeNode* root1, TreeNode* root2) {
        vector<int> l1;
        vector<int> l2;
        store(root1 , l1);
        store(root2 , l2);
        return l1==l2;
    }
};