package com.example.lp010.myapplication.pojo;

import java.util.List;

public class RestaurentResponse {
    /**
     * total_pages : 2
     * error : false
     * error_message : success
     * restuarentlist : [{"id":"3","name":"Mami Tiffen Stall","address":"New No.7, Old No.4, Pitchu Pillai Street, Pitchu St, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600004","city":"Chennai","state":"TN","mobile":"9840272288","lattitude":"13.032452","longtitude":"80.270397","img":"http://www.steats.com/img/0_1518715543_hotels.jpg","favouritecheck":0},{"id":"7","name":"Mylai Karpagambal Mess","address":"20, East Mada Street, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600017","city":"Chennai","state":"TN","mobile":"04424642902","lattitude":"13.0335972","longtitude":"80.271274","img":"http://www.steats.com/img/0_1518885510_hotels.jpg","favouritecheck":0},{"id":"4","name":"Mylapore Jannal Kadai","address":"12, 1, Ponnambala Vadhyar St, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600004","city":"Chennai","state":"TN","mobile":"","lattitude":"13.0330516","longtitude":"80.2699941","img":"http://www.steats.com/img/0_1518715910_hotels.jpg","favouritecheck":0},{"id":"15","name":"Suriya Sweets","address":"41, S Mada St, Alamelu Manga Puram, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600004, India","city":"Chennai","state":"TN","mobile":"","lattitude":"13.032129","longtitude":"80.268423","img":"http://www.steats.com/img/0_1523373560_hotels.jpg","favouritecheck":0},{"id":"17","name":"Senthil Softy Zone","address":"Shop No. 139, Kutchery Road, Mylapore, Chennai, Tamil Nadu 600004","city":"Chennai","state":"TN","mobile":"9940273634","lattitude":"13.0352017","longtitude":"80.2703612","img":"http://www.steats.com/img/0_1523373763_hotels.jpg","favouritecheck":0},{"id":"2","name":"Rayar Mess","address":"31, Arundel St, Madhavaperumalpuram, Mylapore, Chennai, Tamil Nadu 600004, India","city":"Chennai","state":"TN","mobile":"9884682307","lattitude":"13.0355462","longtitude":"80.27262","img":"http://www.steats.com/img/0_1518714930_hotels.JPG","favouritecheck":0},{"id":"14","name":"Gomathi Mess","address":"31/60, Mandaveli Lane, Sankarapuram, Mylapore, Chennai, Tamil Nadu 600004","city":"Chennai","state":"TN","mobile":"9444108923","lattitude":"13.0295988","longtitude":"80.2676827","img":"http://www.steats.com/img/0_1523373429_hotels.jpg","favouritecheck":0},{"id":"5","name":"Mylai Briyani","address":"167, Kutchery Rd, Madhavaperumalpuram, Mylapore, Chennai, Tamil Nadu 600004, India","city":"Chennai","state":"TN","mobile":"8015577667","lattitude":"13.0356237","longtitude":"80.269953","img":"http://www.steats.com/img/0_1518968410_hotels.jpg","favouritecheck":0},{"id":"13","name":"Karpagambal Sweet Stall","address":"15, Apparswamy Ki Street, Mylapore, Mylapore, Chennai, Tamil Nadu 600004","city":"Chennai","state":"TN","mobile":"","lattitude":"13.0402868","longtitude":"80.2674867","img":"http://www.steats.com/img/0_1523372916_hotels.jpg","favouritecheck":0},{"id":"18","name":"Brunch","address":"No.78/103, Dr. Radha Krishnan Salai, Jagadambal Colony, Durgapuram, Mylapore - 6000004","city":"Chennai","state":"TN","mobile":"9940235645","lattitude":"13.0433813","longtitude":"80.275786","img":"http://www.steats.com/img/0_1523373871_hotels.jpg","favouritecheck":0}]
     */

    private int total_pages;
    private String error;
    private String error_message;
    private List<RestuarentlistBean> restuarentlist;

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public List<RestuarentlistBean> getRestuarentlist() {
        return restuarentlist;
    }

    public void setRestuarentlist(List<RestuarentlistBean> restuarentlist) {
        this.restuarentlist = restuarentlist;
    }

    public static class RestuarentlistBean {
        /**
         * id : 3
         * name : Mami Tiffen Stall
         * address : New No.7, Old No.4, Pitchu Pillai Street, Pitchu St, Vinayaka Nagar Colony, Mylapore, Chennai, Tamil Nadu 600004
         * city : Chennai
         * state : TN
         * mobile : 9840272288
         * lattitude : 13.032452
         * longtitude : 80.270397
         * img : http://www.steats.com/img/0_1518715543_hotels.jpg
         * favouritecheck : 0
         */

        private String id;
        private String name;
        private String address;
        private String city;
        private String state;
        private String mobile;
        private String lattitude;
        private String longtitude;
        private String img;
        private int favouritecheck;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getLattitude() {
            return lattitude;
        }

        public void setLattitude(String lattitude) {
            this.lattitude = lattitude;
        }

        public String getLongtitude() {
            return longtitude;
        }

        public void setLongtitude(String longtitude) {
            this.longtitude = longtitude;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public int getFavouritecheck() {
            return favouritecheck;
        }

        public void setFavouritecheck(int favouritecheck) {
            this.favouritecheck = favouritecheck;
        }
    }
}
