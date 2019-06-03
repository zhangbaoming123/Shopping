package com.example.lenovo.shopping.fragment.home.bean;

import java.util.List;

public class MiaoBean {

    /**
     * code : 200
     * dlist : [{"id":1,"name":"秒杀商品1","price":"203.00","ceckil_price":"99.00","description":"这个没啥","quen_id":{"id":1,"name":"春季促销","start_time":"2019-04-30 16:00:00","end_time":"2019-04-30 20:00:00","state":1}},{"id":2,"name":"秒杀商品2","price":"250.00","ceckil_price":"99.00","description":"阿斯达四大","quen_id":{"id":3,"name":"秋季促销","start_time":"2019-09-30 16:00:00","end_time":"2019-10-30 16:00:00","state":1}},{"id":4,"name":"秒杀商品3","price":"120.00","ceckil_price":"66.00","description":"阿斯达四大","quen_id":{"id":4,"name":"冬季促销","start_time":"2019-05-15 16:00:00","end_time":"2019-05-30 16:00:00","state":1}},{"id":5,"name":"秒杀商品4","price":"520.00","ceckil_price":"299.00","description":"阿斯达四大","quen_id":{"id":2,"name":"夏季促销","start_time":"2019-05-30 16:00:00","end_time":"2019-06-03 16:00:00","state":1}},{"id":6,"name":"秒杀商品5","price":"5287.00","ceckil_price":"4999.00","description":"更好更符合法规","quen_id":{"id":1,"name":"春季促销","start_time":"2019-04-30 16:00:00","end_time":"2019-04-30 20:00:00","state":1}},{"id":7,"name":"秒杀商品6","price":"2000.00","ceckil_price":"999.00","description":"范德萨发放给","quen_id":{"id":1,"name":"春季促销","start_time":"2019-04-30 16:00:00","end_time":"2019-04-30 20:00:00","state":1}}]
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
         * name : 秒杀商品1
         * price : 203.00
         * ceckil_price : 99.00
         * description : 这个没啥
         * quen_id : {"id":1,"name":"春季促销","start_time":"2019-04-30 16:00:00","end_time":"2019-04-30 20:00:00","state":1}
         */

        private int id;
        private String name;
        private String price;
        private String ceckil_price;
        private String description;
        private QuenIdBean quen_id;

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

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getCeckil_price() {
            return ceckil_price;
        }

        public void setCeckil_price(String ceckil_price) {
            this.ceckil_price = ceckil_price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public QuenIdBean getQuen_id() {
            return quen_id;
        }

        public void setQuen_id(QuenIdBean quen_id) {
            this.quen_id = quen_id;
        }

        public static class QuenIdBean {
            /**
             * id : 1
             * name : 春季促销
             * start_time : 2019-04-30 16:00:00
             * end_time : 2019-04-30 20:00:00
             * state : 1
             */

            private int id;
            private String name;
            private String start_time;
            private String end_time;
            private int state;

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

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }
        }
    }
}
