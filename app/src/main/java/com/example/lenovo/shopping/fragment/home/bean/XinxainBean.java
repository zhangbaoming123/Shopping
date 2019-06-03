package com.example.lenovo.shopping.fragment.home.bean;

import java.util.List;

public class XinxainBean {

    /**
     * code : 200
     * list : [{"id":1,"name":"林立","pic":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1558012412966&amp;di=443cb0b4b4c83916dc27d7e632c8a6c0&amp;imgtype=0&amp;src=http%3A%2F%2Fpic32.nipic.com%2F20130823%2F13339320_183302468194_2.jpg","subTitle":"风格很反感","price":"23.00","originalPrice":"30.00"},{"id":2,"name":"特步","pic":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1558012412966&amp;di=443cb0b4b4c83916dc27d7e632c8a6c0&amp;imgtype=0&amp;src=http%3A%2F%2Fpic32.nipic.com%2F20130823%2F13339320_183302468194_2.jpg","subTitle":"hgjgh","price":"30.00","originalPrice":"30.00"}]
     */

    private int code;
    private List<ListBean> list;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * id : 1
         * name : 林立
         * pic : https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1558012412966&amp;di=443cb0b4b4c83916dc27d7e632c8a6c0&amp;imgtype=0&amp;src=http%3A%2F%2Fpic32.nipic.com%2F20130823%2F13339320_183302468194_2.jpg
         * subTitle : 风格很反感
         * price : 23.00
         * originalPrice : 30.00
         */

        private int id;
        private String name;
        private String pic;
        private String subTitle;
        private String price;
        private String originalPrice;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getSubTitle() {
            return subTitle;
        }

        public void setSubTitle(String subTitle) {
            this.subTitle = subTitle;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getOriginalPrice() {
            return originalPrice;
        }

        public void setOriginalPrice(String originalPrice) {
            this.originalPrice = originalPrice;
        }
    }
}
