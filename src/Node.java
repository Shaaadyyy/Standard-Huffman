/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package standardhuffman;

/**
 *
 * @author HP
 */
 class Node implements Comparable<Node>
    {
        public final char character;
        public final int frequency;
        public final Node leftChild;
        public final Node rightChild;
        public Node(final char character
                     , final int frequency
                     ,  final Node leftChild,
                     final Node rightChild  )
        {
             this.character=character;
             this.frequency=frequency;
             this.leftChild=leftChild;
             this.rightChild=rightChild;
        }
        public boolean isLeaf()
        {
              return this.rightChild==null&&this.rightChild==null;
        }
         
        @Override
        public int compareTo(final Node that) {
           final int frequncyComparison=Integer.compare((this.frequency), that.frequency);
           if (frequncyComparison!=0) 
               return frequncyComparison;
           return Integer.compare(this.character, that.character);
        }
    }