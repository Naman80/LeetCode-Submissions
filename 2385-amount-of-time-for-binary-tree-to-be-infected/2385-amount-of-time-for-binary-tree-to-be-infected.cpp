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
    TreeNode* infected = NULL;
    map<TreeNode* , TreeNode*> par;
    void find(TreeNode* root, TreeNode* parent , int& start){
        if(root==NULL)return;
        if(infected==NULL && root->val == start)infected = root;
        par[root] = parent;
        find(root->left , root , start);
        find(root->right , root , start);
    }
    int amountOfTime(TreeNode* root, int start) {
        find(root , NULL , start);
        queue<TreeNode*> q;
        q.push(infected);
        map<TreeNode* , bool> vis;
        vis[infected] = true;
        int ans = 0;
        while(q.size()){
            int len = q.size();
            for(int i = 0 ; i < len; i++){
                TreeNode* top = q.front();
                TreeNode* left = top->left;
                TreeNode* right = top->right;
                q.pop();
                if(left!=NULL && vis[left] == false){
                    vis[left] = true;
                    q.push(left);
                }
                if(right!=NULL && vis[right] == false){
                     vis[right]=true;
                    q.push(right);
                }
                if(par[top]!=NULL  && vis[par[top]] == false){
                     vis[par[top]] = true;
                    q.push(par[top]);
                }   
            }
            ans++;
        }
        return ans-1;
    }
};