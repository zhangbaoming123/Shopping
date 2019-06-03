package com.example.lenovo.shopping.fragment.home.bean;

import java.util.List;

public class RenBean {

    /**
     * code : 200
     * dlist : [{"id":0,"name":"","price":null,"description":"","pic":null,"detailHtml":null,"productCategoryName":null,"productAttributeCategoryId":[],"productCategoryId":[],"feightTemplateId":[],"brandId":[]},{"id":1,"name":"林立","price":"23.00","description":"清澈如水,淡入泥潭","pic":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1558012412966&amp;di=443cb0b4b4c83916dc27d7e632c8a6c0&amp;imgtype=0&amp;src=http%3A%2F%2Fpic32.nipic.com%2F20130823%2F13339320_183302468194_2.jpg","detailHtml":"<p>啊实打实大苏打实打实<\/p>","productCategoryName":"夹克","productAttributeCategoryId":[{"id":2,"create_time":"2019-05-14","update_time":"2019-05-14","name":"颜色","productAttributeCategoryId":1,"filterType":0,"searchType":1,"relatedStatus":1,"selectType":1,"inputType":1,"inputList":"黑,黄,绿,紫","handAddStatus":1,"sort":30,"type":0}],"productCategoryId":[],"feightTemplateId":[{"id":1,"name":"无忧退货","title":"30天无忧退货","content":"自收到商品之日起30天内，可在线申请无忧退货服务（内裤、食品等特殊商品除外）"}],"brandId":[{"id":1,"name":"小米","bigPic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","zuidijia":0}]},{"id":2,"name":"特步","price":"30.00","description":"薄如蝉翼，丝滑如肌肤","pic":"https://timgsa.baidu.com/timg?image&amp;quality=80&amp;size=b9999_10000&amp;sec=1558012412966&amp;di=443cb0b4b4c83916dc27d7e632c8a6c0&amp;imgtype=0&amp;src=http%3A%2F%2Fpic32.nipic.com%2F20130823%2F13339320_183302468194_2.jpg","detailHtml":"<p>啊实打实大苏打实打实<\/p>","productCategoryName":"夹克","productAttributeCategoryId":[{"id":2,"create_time":"2019-05-14","update_time":"2019-05-14","name":"颜色","productAttributeCategoryId":1,"filterType":0,"searchType":1,"relatedStatus":1,"selectType":1,"inputType":1,"inputList":"黑,黄,绿,紫","handAddStatus":1,"sort":30,"type":0}],"productCategoryId":[],"feightTemplateId":[{"id":2,"name":"快速退货","title":"48小时快速退货","content":"收到退货包裹并确认无误后，将在48小时内办理退款，退款将原路返回，不同银行处理时间不同，预计1-5个工作日到账。"}],"brandId":[{"id":2,"name":"华为","bigPic":"http://img2.cheshi-img.com/product/1_1024/p/36200/36297/53549cd420efa.jpg","zuidijia":0}]}]
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
         * id : 0
         * name :
         * price : null
         * description :
         * pic : null
         * detailHtml : null
         * productCategoryName : null
         * productAttributeCategoryId : []
         * productCategoryId : []
         * feightTemplateId : []
         * brandId : []
         */

        private int id;
        private String name;
        private Object price;
        private String description;
        private Object pic;
        private Object detailHtml;
        private Object productCategoryName;
        private List<?> productAttributeCategoryId;
        private List<?> productCategoryId;
        private List<?> feightTemplateId;
        private List<?> brandId;

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

        public Object getPrice() {
            return price;
        }

        public void setPrice(Object price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Object getPic() {
            return pic;
        }

        public void setPic(Object pic) {
            this.pic = pic;
        }

        public Object getDetailHtml() {
            return detailHtml;
        }

        public void setDetailHtml(Object detailHtml) {
            this.detailHtml = detailHtml;
        }

        public Object getProductCategoryName() {
            return productCategoryName;
        }

        public void setProductCategoryName(Object productCategoryName) {
            this.productCategoryName = productCategoryName;
        }

        public List<?> getProductAttributeCategoryId() {
            return productAttributeCategoryId;
        }

        public void setProductAttributeCategoryId(List<?> productAttributeCategoryId) {
            this.productAttributeCategoryId = productAttributeCategoryId;
        }

        public List<?> getProductCategoryId() {
            return productCategoryId;
        }

        public void setProductCategoryId(List<?> productCategoryId) {
            this.productCategoryId = productCategoryId;
        }

        public List<?> getFeightTemplateId() {
            return feightTemplateId;
        }

        public void setFeightTemplateId(List<?> feightTemplateId) {
            this.feightTemplateId = feightTemplateId;
        }

        public List<?> getBrandId() {
            return brandId;
        }

        public void setBrandId(List<?> brandId) {
            this.brandId = brandId;
        }
    }
}
