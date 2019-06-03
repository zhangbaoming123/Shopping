package com.example.lenovo.shopping.fragment.classify.bean;

import java.util.List;

public class ClassifyReBean {

    /**
     * code : 200
     * dlist : [{"id":1,"name":"上衣","list":[{"id":2,"name":"毛衣"},{"id":3,"name":"夹克"}]},{"id":1,"name":"上衣","list":[{"id":2,"name":"毛衣"},{"id":3,"name":"夹克"}]},{"id":4,"name":"电器","list":[{"id":5,"name":"大哥大"}]},{"id":6,"name":"球鞋","list":[{"id":7,"name":"阿三"}]}]
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
         * id : 1
         * name : 上衣
         * list : [{"id":2,"name":"毛衣"},{"id":3,"name":"夹克"}]
         */

        private int id;
        private String name;
        private List<ListBean> list;

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

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * name : 毛衣
             */

            private int id;
            private String name;

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
        }
    }
}
