<script>
import { Icon } from '@iconify/vue';
import { TransitionGroup } from 'vue';
import CommentView from '../components/Comment.vue';
import axios from 'axios';
export default {
    components: {
        Icon,
        CommentView,

    },
    data() {
        return {
            //貼文Id
            postId: null,
            //貼文按讚數
            up: 0,
            //貼文分享數
            shareId: null,
            //發文時間
            time: "",
            //單純判斷有沒有按過讚(回傳1是有，回傳0是沒按過讚)
            likeYesOrNo: null,
            //按讚貼文及收回讚的顯示顏色
            isNiceClick: false,
            //貼文資訊
            postList: [],
            //發文者的資訊
            userInfoList: [],
            //發文者名字
            userName: "",
            //發文者Id
            userId: null,
            //貼文內容
            text: "",
            //傳入按讚人Req
            likePostUserInfo: { "PostId": null, "UserId": null },


        }
    },
    methods: {
        //點留言按鈕後游標移動到留言輸入框
        goToInput() {
            this.$refs.ipt.focus();
        },
        //貼文按讚
        likeClick() {
            //附值到按讚人Req
            this.likePostUserInfo.PostId = this.postId;
            this.likePostUserInfo.UserId = this.userId;

            //將按讚人的資訊存入資料庫
            //post請求
            axios.post('http://localhost:8080/add/like/info/', this.likePostUserInfo)
                .then(data => {
                    this.getUp();
                })
        },
        //單純判斷資料庫有無按讚資料
        likeYesOrNoInfo() {
            axios.post('http://localhost:8080/like/yes/or/no/', {

                "PostId": this.postId,
                "UserId": this.userId

            })
                .then(data => {
                    this.likeYesOrNo = data.data;
                    //貼文按讚後變色
                    if (this.likeYesOrNo === 1) {
                        this.isNiceClick = true;
                    } else {
                        this.isNiceClick = false;
                    }
                })

        },
        getUp() {
            // Get貼文的資訊
            fetch("http://localhost:8080/post/get?limit=20000000")
                .then(res => res.json())
                .then(data => {
                    this.postList = data;
                    this.up = this.postList.post.up
                    //判斷按讚要回傳postId
                    this.postId = this.postList.post.postId
                    this.shareId = this.postList.post.shareId
                    this.text = this.postList.post.text
                    this.time = this.postList.post.time.slice(0, 10)

                })
        }
    },
    mounted() {
        // Get發文者的資訊
        fetch("http://localhost:8080/user/get/info?take=10000000")
            .then(res => res.json())
            .then(data => {
                this.userInfoList = data;
                this.userName = this.userInfoList.userData.userName;
                //判斷按讚要回傳userId
                this.userId = this.userInfoList.userData.userId;
            })
        //Get貼文資訊
        this.getUp();
        //單純判斷資料庫有無按讚資料
        this.likeYesOrNoInfo();

    },
    updated() {
        this.likeYesOrNoInfo();
    },
}

</script>

<template>
    <!-- 外框 -->
    <div class="container">
        <!-- 圖片的外框 -->
        <div class="pic_outside_frame">
            <!-- 貼文照片 -->
            <img class="pic" src="./../../public/img/Test3.jpg" alt="圖片載入失敗">
        </div>
        <!-- 右方貼文區 -->
        <div class="post_aera">
            <!-- 發文者區 -->
            <div class="user_aera">
                <!-- 發文者頭貼框 -->
                <div class="user_icon_frame">
                    <!-- 發文者的頭貼 -->
                    <img class="user_icon" src="./../../public/img/icon1.jpg" alt="圖片載入失敗">
                </div>
                <!-- 發文者資訊區 -->
                <div class="user_info">
                    <!-- 發文者名字 -->
                    <div class="user_name">
                        <h2>{{ userName }}</h2>
                    </div>
                    <!-- 發文者的粉絲數 -->
                    <div class="follower">
                        <h3>粉絲數:257人</h3>
                    </div>
                </div>

            </div>
            <!-- 發文內容區 -->
            <div class="text_aera">
                <!-- 發文內容 -->
                <p>{{ text }}</p>
                <!-- 按讚分享日期的區域 -->
                <div class="reaction_aera">
                    <!-- 按讚資訊 -->
                    <div class="like_info">
                        <span class="like">按讚</span>
                        <span v-if="this.up > 0">{{ up }}</span>
                    </div>
                    <!-- 分享資訊 -->
                    <div class="share_info">
                        <span class="share">分享</span>
                        <span v-if="this.shareId > 0">{{ shareId }}</span>
                    </div>
                    <!-- 發文日期資訊 -->
                    <span class="date">{{ time }}</span>
                </div>
                <!-- 功能Bar定位框 -->
                <div class="action_bar_frame">
                    <!-- 功能Bar -->
                    <div class="action_bar">
                        <button :class="{ niceClick: isNiceClick }" v-on:click="likeClick" type="button">按讚</button>
                        <button @click="goToInput" type="button">留言</button>
                        <button type="button">分享</button>
                    </div>
                </div>
                <!-- 留言定位框 -->
                <div class="command_frame">
                    <!-- 留言區域 -->
                    <div class="command_aera">
                        <!-- <CommentView v-for="(item, index) in [a,b]" :key="index" /> -->
                        <CommentView />
                        <!-- 留言的元件 -->
                    </div>
                </div>
                <!-- 輸入留言的定位框 -->
                <div class="input_frame">
                    <!-- 輸入留言 -->
                    <input ref="ipt" class="input_command" type="text">
                    <!-- 送出留言的Icon -->
                    <Icon class="icon_send" icon="carbon:send" color="#6ea627" />
                </div>


            </div>



        </div>






    </div>
</template>

<style lang="scss" scoped>
//外框
.container {
    display: flex;
    background-image: linear-gradient(to top, #6EAC00, #D6FC95);
    width: 1400px;
    height: 800px;
    border-radius: 20px;
    z-index: 3;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);


    //圖片的外框
    .pic_outside_frame {
        // border: 2px solid blueviolet;
        width: 950px;
        height: 750px;
        margin: 0 auto;
        margin-top: 2%;

        //圖片
        .pic {
            width: 100%;
            height: 100%;
            border-radius: 15px;
        }

    }

    //右方貼文區
    .post_aera {
        // border: 2px solid red;
        width: 390px;

        //發文者區
        .user_aera {
            margin-top: 6%;
            display: flex;
            background-color: #6EA627;
            width: 370px;
            height: 120px;
            border-radius: 15px;
            margin-bottom: 5%;

            //發文者頭貼框
            .user_icon_frame {
                width: 120px;
                height: 120px;
                // border: 2px solid purple;
                margin-right: 5%;
                border-radius: 15px;

                //發文者的頭貼
                .user_icon {
                    width: 100%;
                    height: 100%;
                    border-radius: 15px;
                }
            }

            //發文者資訊區
            .user_info {

                //發文者名字
                .user_name {}

                //發文者的粉絲數
                .follower {}

            }


        }

        //發文內容區
        .text_aera {
            background-color: white;
            width: 370px;
            word-wrap: break-word;
            border-radius: 15px 15px 15px 15px;
            overflow-y: scroll;
            max-height: 618px;

            &::-webkit-scrollbar {
                border-radius: 4px;
                width: 8px;
                // background: #6EAC00;

            }

            &::-webkit-scrollbar-thumb {
                background: rgb(178, 172, 172);

                border-radius: 4px;

            }

            p {
                width: 100%;
                padding-left: 1rem;
                padding-right: 1.5rem;
                background-color: white;


            }

            .reaction_aera {
                text-align: center;
                display: flex;
                justify-content: space-around;

                span {
                    font-size: larger;
                }

                .like,
                .share,
                .date {
                    padding-left: 1rem;

                }

            }




            //功能Bar定位框
            .action_bar_frame {
                display: flex;
                justify-content: center;

                //功能Bar
                .action_bar {
                    left: 0px;
                    bottom: 0px;
                    background-color: #6EAC00;
                    width: 95%;
                    height: 100px;
                    display: flex;
                    justify-content: space-evenly;
                    align-items: center;
                    // border-radius: 0px 0 0 15px;
                    margin-bottom: 1rem;
                    border-radius: 15px;


                    button {
                        width: 60px;
                        height: 50px;
                        border-radius: 10px;
                        border: #D6FC95;
                        transition: 0.75;
                        cursor: pointer;

                        &:hover {
                            scale: 0.95s;

                        }

                        &:active {
                            scale: 0.95s;
                        }


                    }

                    .niceClick {
                        background-color: #D6FC95;
                    }

                }
            }

            //留言定位框
            .command_frame {



                //留言區域
                .command_aera {
                    width: 100%;
                    background-color: #D9D9D9;
                }

            }

            //輸入留言的定位框
            .input_frame {
                display: flex;
                position: relative;
                justify-content: center;
                margin-bottom: 1rem;
                margin-top: 1rem;

                // 輸入留言
                .input_command {
                    width: 350px;
                    height: 40px;
                    border-radius: 8px;
                    font-size: 20px;
                    padding-right: 50px;
                }

                //送出留言的Icon
                .icon_send {
                    position: absolute;
                    top: 0px;
                    right: 10px;
                    width: 40px;
                    height: 40px;

                    &:active {
                        scale: 1.05;
                    }

                }
            }


        }



    }


}
</style>