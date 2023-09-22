<script>
export default {
    data() {
        return {

        }
    },
    methods: {

    }
}

</script>

<template>
    <!-- 外框 -->
    <div class="container">
        <!-- 圖片的外框 -->
        <div class="pic-outside-frame">
            <!-- 貼文裡的按鈕 -->
            <button class="nice-btn btn" type="button">按讚</button>
            <button class="save-btn btn" type="button">收藏</button>
            <button class="share-btn btn" type="button">分享</button>
            <!-- 組件變黑 -->
            <div class="bcg-black"></div>
            <!-- 貼文照片 -->
            <img class="pic" src="./../../public/img/Test3.jpg" alt="圖片載入失敗">
        </div>
        <!-- 貼文內容的外框 -->
        <div class="text-outside-frame">
            <!-- 發文者的頭貼框 -->
            <div class="icon-frame">
                <!-- 發文者的頭貼 -->
                <img class="user-icon" src="./../../public/img/icon1.jpg" alt="圖片載入失敗">
            </div>
            <!-- 貼文內容框 -->
            <div class="text-frame">
                <!-- 貼文內容 -->
                <p>大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛大耳狗的蛋包飯很可愛</p>
            </div>
        </div>
    </div>
</template>

<style lang="scss" scoped>
//貼文的外框
.container {
    position: relative;
    width: 450px;
    border-radius: 20px;
    background-color: #C9FF84;
    box-sizing: border-box;
    padding: 0, 100px;


    //組件變黑
    .bcg-black {
        display: none;
        position: absolute;
        width: 450px;
        height: 100%;
        border-radius: 20px;
        background: black;
        opacity: 0.3;
        z-index: 1;
    }



    //圖片的外框
    .pic-outside-frame {
        // border: 2px solid rgb(185, 7, 240);
        width: 450px;
        margin: 0 auto;
        margin-top: 2%;


        &:hover {

            .nice-btn,
            .save-btn,
            .share-btn,
            .bcg-black {
                display: block;
            }
        }

        //貼文裡的按鈕
        .btn {
            display: none;
            background-color: white;
            width: 68px;
            height: 68px;
            z-index: 2;
            border-radius: 50px;
            border: none;
            cursor: pointer;
            transition: 0.2s;

            &:hover {
                scale: 1.05s;
            }

            &:active {
                background-color: #79ce09;
                scale: 0.95s;
            }
        }

        //按讚按鈕
        .nice-btn {
            // background-image: url('./../../public/img/nice.png');
            position: absolute;
            right: 10px;
            top: 30px;
        }

        //收藏按鈕
        .save-btn {
            background-image: url('./../../public/img/save.png');
            position: absolute;
            right: 10px;
            top: 105px;
        }

        //分享按鈕
        .share-btn {
            background-image: url('./../../public/img/share.png');
            position: absolute;
            right: 10px;
            top: 180px;
        }


        //貼文照片
        .pic {
            position: relative;
            width: 100%;
            height: 100%;
            border-radius: 15px;
            margin-top: 3%;
            padding-left: 10px;
            padding-right: 10px;
            justify-content: center;

            &:hover {
                .bcg-black {
                    display: block;
                }

            }


        }


    }


    //貼文內容的外框
    .text-outside-frame {
        display: flex;
        align-items: center;
        width: 450px;
        height: 80px;
        border-radius: 0 0 20px 20px;
        // border: 2px solid rgb(0, 89, 255);


        //發文者的頭貼框
        .icon-frame {
            width: 60px;
            height: 60px;
            border: 2px solid black;
            margin-left: 6%;
            margin-right: 5%;
            border-radius: 15px;


            //發文者的頭貼
            .user-icon {
                width: 60px;
                height: 60px;
                border-radius: 15px;

            }

        }

        //貼文內容框
        .text-frame {
            height: 60px;
            border: 2px solid black;
            cursor: pointer;

            //貼文內容
            p {
                width: 300px;
                overflow: hidden;
                white-space: nowrap;
                text-overflow: ellipsis;
            }
        }

    }
}
</style>

