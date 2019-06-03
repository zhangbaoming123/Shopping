package com.example.lenovo.shopping.fragment.home.bean;

import java.util.List;

public class LikeBean {

    /**
     * code : 200
     * dlist : [{"name":"风火山林","note":"风火山林","description":"这个邪不错","amount":"200.00","pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","id":1},{"name":"艾克凯特","note":"艾克凯特","description":"这个争夺挺好","amount":"522.00","pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","id":2},{"name":"i内特卡莱","note":"i内特卡莱","description":"i内特卡莱不错不错","amount":"300.00","pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","id":3},{"name":"阿达","note":"阿九阿九急啊急啊","description":"实打实大苏打","amount":"666.00","pic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","id":4}]
     */

    private int code;
    private List<DlistBean> dlist;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DlistBean> getDlist() {
        return dlist;
    }

    public void setDlist(List<DlistBean> dlist) {
        this.dlist = dlist;
    }

    public static class DlistBean {
        /**
         * name : 风火山林
         * note : 风火山林
         * description : 这个邪不错
         * amount : 200.00
         * pic : http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg
         * id : 1
         */

        private String name;
        private String note;
        private String description;
        private String amount;
        private String pic;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNote() {
            return note;
        }

        public void setNote(String note) {
            this.note = note;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
