package megvii.testfacepass.beans;

/**
 * Created by Administrator on 2018/4/8.
 */

public class TuiSongBean {


    /**
     * content : {"id":10000102,"status":2}
     * title : 主机管理
     */

    private ContentBean content;
    private String title;

    public ContentBean getContent() {
        return content;
    }

    public void setContent(ContentBean content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static class ContentBean {
        /**
         * id : 10000102
         * status : 2
         */

        private int id;
        private int status;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
