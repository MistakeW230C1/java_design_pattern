package com.mistake.day7.demo2;

/**
 * @author mistake
 */
public interface IItem {
    /**
     * getAccount
     *
     * @return String
     */
    String getAccount();

    /**
     * setAccount
     *
     * @param s
     */
    void setAccount(String s);

    /**
     * getName
     *
     * @return String
     */
    String getName();

    /**
     * setName
     *
     * @param s
     */
    void setName(String s);

    /**
     * getProject
     *
     * @return String
     */
    String getProject();

    /**
     * setProject
     *
     * @param s
     */
    void setProject(String s);

    /**
     * getContent
     *
     * @return String
     */
    String getContent();

    /**
     * getPlan
     *
     * @return String
     */
    String getPlan();

    /**
     * itemFill
     */
    void itemFill() throws Exception;
}
