package Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Date;

/**
 *
 * @author asraf
 */
public class ConfessionPost {
    private String postID;
    private static int ID=0;
    private String content;
    private Date postTime;
    
    public ConfessionPost(){
    }
    /**
     * Creates an instance of Confession Post.
     * @param postID    Confession Post ID is unique
     * @param content   The content of a Confession Post
     */
    public ConfessionPost(String postID, String content) {                      
        this.postID = postID;
        this.content = content;
        this.postTime = new Date();
    }
    
    /**
     * Add a Confession Post to the object.
     * @param content the content of a Confession Post.
     * @return        new Confession Post ID.
     */
    public String addPost(String content){
        String newID = generateID();
        this.postID = newID;
        this.content = content;
        this.postTime = new Date();
        return newID;
    }
    
    /**
     * Returns the date of when the post was created.
     * @return      the date of a post
     */
    public String getTime(){
        return ""+postTime;
    }
    
    /**
     * Returns the content of the Confession Post.
     * @return      the content of a post
     */
    public String getContent(){
        return content;
    }
    
    /**
     * Returns the post ID of the Confession Post.
     * @return      the post ID of a post
     */
    public String getID(){
        return postID;
    }
    
    /**
     * Creates a unique Confession Post ID.
     * This method generate an ID by checking the data class.
     * If a post ID already taken, it will increase counter by 1 until
     * it found an available post ID.
     * @return      the generated post ID of the new post
     */
    public String generateID(){
        postID = "UM0"+ID;
        ID++;
        if(!checkAvailableID(postID)){
            generateID();
        }
        return postID;
    }
    /**
     * Returns true if newly generated post ID is not found in the data class.
     * @param postID    newly generated post ID from generateID()
     * @return          true, if newly generated post ID is not found in the data class
     */
    public Boolean checkAvailableID(String postID){
        Data data = new Data();
        return data.searchData(postID)==null;
    }
    
    @Override
    public String toString() {
        return "\npostID=" + postID + "\ncontent=" + content + "\npostTime=" + postTime;
    }
    /**
     * Returns true if a post from a data class is equal to this post ID.
     * @param id    Confession Post ID to be compared
     * @param data  Confession Post from a data class
     * @return      true, if both posts ID are equal
     */
    public boolean hasID(String id,ConfessionPost data) {
        return data.postID.equals(id);
    }
    
    
    
}
