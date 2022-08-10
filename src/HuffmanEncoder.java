/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package standardhuffman;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
/**
 *
 * @author HP
 */

public class HuffmanEncoder {
    private static final int AlPHABET_SIZE=256;

    
    
    public HuffmanEncodedResult compress(final String data)
    {
        final int[] freq=buildFrequencyTable(data);
        final Node root=buildHuffmanTree(freq); 
        //build lookupTable and give it root
        final Map<Character,String>lookupTable=buildLookupTable(root);
        return new HuffmanEncodedResult(generateEncodedData(data,lookupTable),root);
                                                             
    }
    private static String generateEncodedData(String data,final Map<Character,String>lookupTable)
    {
        final StringBuilder builder=new StringBuilder();
        for(final char character:data.toCharArray())
        {
            builder.append((lookupTable.get(character)));
        }
        return builder.toString();
    }
    //map each character to a binary encoding
    private static Map<Character,String> buildLookupTable(final Node root)
    {
        Map<Character,String>lookupTable=new HashMap<>();
        buildLookUpTableImpl(root,"",lookupTable);
        return lookupTable;
    }
    private static void buildLookUpTableImpl(final Node node, 
                                          final String s, 
                                          final Map<Character,String> lookupTable) 
    {
        if(!node.isLeaf()) 
        {
            //every time we go left we encode 0
            buildLookUpTableImpl(node.leftChild,s+'0',lookupTable);
            //every time we go right we encode 1
            buildLookUpTableImpl(node.rightChild,s+'1',lookupTable);
            
        }
        else
        {
            //just put the code if it's a leaf node
            lookupTable.put(node.character,s);
        }
    }

    private static Node buildHuffmanTree(int[]freq)
    {
        final PriorityQueue<Node>priorityQueue=new PriorityQueue<>();
        //loop through all chars of alphabets
        for(char i=0;i<AlPHABET_SIZE;i++)
        {
            // it is already encoded then create it
            if(freq[i]>0)
            {
                priorityQueue.add(new Node(i,freq[i],null,null));
            }
        }
        if(priorityQueue.size()==1)
        {
            priorityQueue.add(new Node('\0',1,null,null));
        }
        //more than one node
        while(priorityQueue.size()>1)
        {
            final Node left=priorityQueue.poll();
            final Node right=priorityQueue.poll();
            //merge them
            final Node parent=new Node('\0',left.frequency+right.frequency,left,right);
            priorityQueue.add(parent);
        }
        return priorityQueue.poll();//root node
    }
    private static int[] buildFrequencyTable(final String data)
    {
        final int[] freq=new int[AlPHABET_SIZE];
        for(final char character :data.toCharArray())
        {
            freq[character]++;
        }
        return freq;
    }
    //////////////////decompression/////////////////////////////////////////////
    public String decompress(final HuffmanEncodedResult result)
    {
        final StringBuilder resultBuilder=new StringBuilder();
        Node current=result.getRoot();
        int i=0;
        while(i<result.getencodedData().length())
        {
            while (!current.isLeaf())
            {
                char bit=result.getencodedData().charAt(i);
                if(bit=='1')
                {
                    current=current.rightChild;
                }
                else if(bit=='0')
                {
                    current=current.leftChild;
                }
                else
                {
                    //throw new IllegalAurgementException("InvlaidBit "+bit);
                }
                i++;
            }
            resultBuilder.append(current.character);
            current=result.getRoot();
        }
        return resultBuilder.toString();
    }
    
    public static void main(String[] args) {
        


       
    }
}
