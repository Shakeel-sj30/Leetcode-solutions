class Solution {
    public boolean isValid(String sh) {
        Stack<Character> s= new Stack<>();
        for(char ch :sh.toCharArray()){
            if((ch=='{') || (ch=='(') ||(ch=='[')){
            s.push(ch);
        } 
             else{
                if(s.isEmpty()) return false;
                char top = s.pop();
                if((ch=='}' && top=='{') || (ch==']' && top =='[') || (ch ==')' && top =='(')){
                continue;
            }
                else {
                return false;}
        }
        
       
    }
     
   return s.isEmpty(); 

}
}