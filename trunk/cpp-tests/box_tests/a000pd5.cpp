struct Node {
     char data ;
     Node *next ; } ;

 int main() {

    // Build a list
    Node *oldList = 0 ;
    for( int i = 0 ; i < 4 ; i = i+1 ) {
        Node *tmp = new Node ;
        tmp->next = oldList ;
        oldList = tmp ; }
    oldList->data = 'T' ;
    oldList->next->data = 'e' ;
    oldList->next->next->data = 's' ;
    oldList->next->next->next->data = 't' ;

    //Copy the list
                          
    Node *newList ;
    Node **pp = & newList ;
    for( Node *p = oldList ; p != 0 ; p = p->next ) {
        Node *tmp = new Node ;
        tmp->data = p->data ;
        *pp = tmp ;
        pp = & (tmp->next) ; }
    *pp = 0 ;
    
    return ;
 }
                                