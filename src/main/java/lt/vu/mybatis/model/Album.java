package lt.vu.mybatis.model;

public class Album {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM.ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.ALBUM.MUSICIAN_ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    private Integer musicianId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM.ID
     *
     * @return the value of PUBLIC.ALBUM.ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM.ID
     *
     * @param id the value for PUBLIC.ALBUM.ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM.TITLE
     *
     * @return the value of PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM.TITLE
     *
     * @param title the value for PUBLIC.ALBUM.TITLE
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.ALBUM.MUSICIAN_ID
     *
     * @return the value of PUBLIC.ALBUM.MUSICIAN_ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public Integer getMusicianId() {
        return musicianId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.ALBUM.MUSICIAN_ID
     *
     * @param musicianId the value for PUBLIC.ALBUM.MUSICIAN_ID
     *
     * @mbg.generated Tue Apr 13 13:12:35 EEST 2021
     */
    public void setMusicianId(Integer musicianId) {
        this.musicianId = musicianId;
    }
}