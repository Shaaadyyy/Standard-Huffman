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
public class HuffmanEncodedResult
    {
          final Node root;
          final String encodedData;
          public String getencodedData()
          {
              return this.encodedData;
          }
          HuffmanEncodedResult(final String encodedData,final Node root)
          {
              this.encodedData=encodedData;
              this.root=root;
          }
          public Node getRoot()
         {
             return this.root;
         }
    }
