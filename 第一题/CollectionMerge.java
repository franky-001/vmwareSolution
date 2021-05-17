package vmware;

import java.util.Comparator;
import java.util.List;

public class CollectionMerge {


	//��һ��
	public static void main(String[] args) {
		
	}
	
	//����1��ֱ��ʹ��List �ӿ���Ϊ����
	public static <E> List mergeCollections(List head1,List head2,Comparator<? super E> c){
		if(head1==null) return head2;
		if(head2==null) return head1;
		head1.addAll(head2);
		head1.sort(c);
		return head1;
		
		
	}
	
	//����2�� ���Զ��������ڵ㣬�ڵ�����ʹ�÷���
	public Node mergeTwoLists(Node l1, Node l2,Comparator c) {
        if(l1 == null && l2 == null)
            return null;
        if(l1 == null && l2 != null)
            return l2;
        if(l2 == null && l1 != null)
            return l1;
        Node p = l1;
        Node q = l2;
        Node newHead = new Node();//����ͷ���
        Node r = newHead;
        while(p != null && q != null){
            if(c.compare(p.item, q.item)<0){  
                r.next = p;
                p = p.next;
                r = r.next;
            } else {
                r.next = q;
                q = q.next;
                r = r.next;
            }
        }
        
        if(p != null)
           r.next = p;
        if(q != null)
           r.next = q;
        return newHead.next;
    }

	
	private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;
        
        Node() {
            
        }

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }


}
