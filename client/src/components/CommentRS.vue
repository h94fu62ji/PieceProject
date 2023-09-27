<script>
import PullDownMenuVeiw from '../components/PullDownMenu.vue'
import axios from 'axios';
export default {
    components: {
        PullDownMenuVeiw,
    },
    data() {
        return {
            //留言內容
            message: "",
            //展開全文
            isExpanded: false,
            //留言的編輯選單
            isShow: false,
            //留言相關的List
            posCommendtList: [],
            //單純判斷有沒有按過讚(回傳1是有，回傳0是沒按過讚)
            likeYesOrNo: null,
            //按讚留言及收回讚的顯示顏色
            isCommendClick: false,
            //UserList
            commendUserInfo: [],
            //留言者名字
            commendUserName: "",
            //留言的按讚數
            up: null,
            //留言時間
            commentTime: "",
            //留言的ID
            commendId: null,
            //留言者ID
            commendUserId: null,
            //傳入按讚人Req
            likeCommendUserInfo: { "PostId": null, "UserId": null },



        }
    },
    methods: {
        openMenu() {
            this.isShow = !this.isShow;
        },
        comment_like_click() {
            //附值到按讚人Req
            this.likeCommendUserInfo.PostId = this.commendId;
            this.likeCommendUserInfo.UserId = this.commendUserId;
            //將按讚人的資訊存入資料庫
            //post請求
            axios.post('http://localhost:8080/add_commend_like_info/', this.likeCommendUserInfo)
                .then(data => {
                    this.getUp();
                })
        },
        //單純判斷資料庫有無按讚資料
        commendLikeYesOrNoInfo() {
            this.likeCommendUserInfo.PostId = this.commendId;
            this.likeCommendUserInfo.UserId = this.commendUserId;

            axios.post('http://localhost:8080/like/yes/or/no/', this.likeCommendUserInfo)
                .then(data => {
                    this.likeYesOrNo = data.data;
                    //貼文按讚後變色
                    if (this.likeYesOrNo === 1) {
                        this.isCommendClick = true;
                    } else {
                        this.isCommendClick = false;
                    }
                })
        },
        getUp() {
            // Get貼文的留言
            fetch("http://localhost:8080/post/get/commend/30000003")
                .then(res => res.json())
                .then(data => {
                    this.posCommendtList = data;
                    this.commentUserName = this.posCommendtList.postMesg.senderId
                    this.message = this.posCommendtList.postMesg.text;
                    this.up = this.posCommendtList.postMesg.up;
                    //要存入按讚表的留言ID
                    this.commendId = this.posCommendtList.postMesg.messageId
                    this.commentTime = this.posCommendtList.postMesg.time.replace("T", " ")

                });

        }

    },
    mounted() {
        //Get留言者資料
        fetch("http://localhost:8080/user/get/info?take=10000001")
            .then(res => res.json())
            .then(data => {
                this.commendUserInfo = data;
                this.commendUserName = this.commendUserInfo.userData.userName;
                //要存入按讚表的按讚者ID
                this.commendUserId = this.commendUserInfo.userData.userId;
            })

        //Get留言資訊
        this.getUp();
        //單純判斷資料庫有無按讚資料
        this.commendLikeYesOrNoInfo();


    },
    updated() {
        this.commendLikeYesOrNoInfo();
    },
    computed: {
        truncatedMessage() {
            if (this.isExpanded || this.message.length <= 20) {
                return this.message;
            } else {
                return this.message.slice(0, 20) + '...';
            }
        }
    },
}


</script>

<template>
    <!-- 外框 -->
    <div class="outside_frame">
        <!--留言者頭貼框 -->
        <div class="other-user-icon-frame">
            <!-- 留言者的頭貼 -->
            <img class="other-user-icon" src="./../../public/img/icon2.jpg" alt="圖片載入失敗">
        </div>
        <!-- 留言者資訊區 -->
        <div class="comment_user_info_aera">
            <!-- 留言者名字 -->
            <p class="comment_user_name">{{ commendUserName }}</p>
            <!-- 留言內容 -->
            <p class="comment_info">{{ truncatedMessage }}</p>
            <span v-if="!isExpanded && message.length > 20" class="expand-link" @click="isExpanded = true">展開全文</span>
            <!-- 留言時間分隔線 -->
            <hr>
            <!-- 留言時間 -->
            <span class="comment_time">{{ commentTime }}</span>
            <!-- 留言按讚 -->
            <button :class="{ commendClick: isCommendClick }" v-on:click="comment_like_click" class="comment_like"
                type="button">讚</button>
            <!-- 留言的讚數 -->
            <span v-if="this.up > 0" class="comment_like_count">{{ up }}</span>

        </div>
        <!-- 留言的編輯選單 -->
        <div v-on:click="openMenu" class="comment_edit">
            <PullDownMenuVeiw v-if="isShow" />
        </div>

    </div>
</template>

<style lang="scss" scoped>
//外框
.outside_frame {
    position: relative;
    width: 100%;
    height: 100%;
    margin: 0.5rem 0;
    display: flex;

    // border: 2px solid red;
    &:hover {
        .comment_edit {
            display: block;
        }
    }

    //留言者頭貼框
    .other-user-icon-frame {
        width: 60px;
        height: 60px;
        margin-right: 2px;


        ////留言者頭貼
        .other-user-icon {
            width: 100%;
            height: 100%;
        }
    }

    //留言者資訊區
    .comment_user_info_aera {
        width: 100%;
        height: 100%;
        // border: 2px solid rgb(228, 155, 7);


        //留言者名字
        .comment_user_name {
            margin: 0;
            font-weight: bold;
            font-size: 15px;


        }

        //留言內容
        .comment_info {
            margin: 0;
            font-size: 14px;
        }

        a {
            color: #6EAC00;
            font-weight: bold;
            font-size: 14px;
            cursor: pointer;
        }

        //展開全文的樣式
        .expand-link {
            margin: 0;
            color: #6EAC00;
            font-weight: bold;
            font-size: 14px;
            cursor: pointer;
            margin-top: 2px;
        }

        //留言時間分隔線
        hr {
            margin: 0px;
        }


        //留言時間
        .comment_time {
            margin: 0;
            font-size: 10px;
            color: rgb(49, 49, 49);

        }

        //留言按讚
        .comment_like {
            margin-left: 10px;
            font-size: 10px;
            color: rgb(49, 49, 49);
            border: none;
            cursor: pointer;
            background-color: #D9D9D9;

            &:active {
                scale: 1.05;

            }

        }

        .commendClick {
            color: #6EAC00;
        }

        //留言的讚數
        .comment_like_count {
            font-size: 10px;
            font-weight: bold;
            color: #6EAC00;
        }
    }

    //留言的編輯選單
    .comment_edit {
        display: none;
        position: absolute;
        top: 2px;
        right: 8px;
        background-color: black;
        width: 3px;
        height: 3px;
        border-radius: 70px;
        cursor: pointer;

        &:active {
            scale: 1.05;
        }

        &::before {
            position: absolute;
            top: 6px;
            content: "";
            background-color: black;
            width: 3px;
            height: 3px;
            border-radius: 70px;

        }

        &::after {
            position: absolute;
            top: 12px;
            content: "";
            background-color: black;
            width: 3px;
            height: 3px;
            border-radius: 70px;
        }

    }
}
</style>