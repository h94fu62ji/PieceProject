<script >
export default {
    data() {
        return {
            emailaddress: ''
        }
    },

}
</script>

<template>
    <div class="h-screen w-screen flex justify-center items-center">
        <!-- main -->
        <div class="z-10">
            <!-- LOGO -->
            <div class="flex justify-center items-center">

                <img class="flex w-32 h-32" src="../../public/logo.png" alt="">

            </div>
            <!-- 口號 -->
            <p class=" mt-2 flex justify-center items-center text-[#5A7A22] tracking-[7px] text-[1px] font-semibold">成為我們的一塊
            </p>
            <!-- 輸入信箱 -->
            <div class="flex flex-col  items-center mt-2 ">

                <input
                    class="  focus:outline-[#90a073]  w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[12px] "
                    type="text" placeholder="輸入註冊信箱">
                <p class=" flex text-[#909090] text-[1px]  ml-[420px] mt-1">帳號不存在</p>
            </div>
            <!-- 輸入驗證碼 -->
            <!-- <div class="flex  justify-center ">

                <div class="flex flex-col  items-center mt-2 ">

                    <input
                        class=" focus:outline-[#90a073] w-[360px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[12px] "
                        type="text" placeholder="輸入驗證碼">
                    <p class=" flex text-[#909090] text-[1px]  ml-[275px] mt-1">驗證碼錯誤</p>

                </div>
                <div>

                    <button
                        class="hover:scale-105 w-32 h-9 mt-3  ml-3 rounded-[5px] text-center text-white bg-gradient-to-r from-[#6EA627] to-[#96C659]  font-semibold  inline-block"
                        type="button">發送驗證碼</button>
                    <p class=" flex text-[#909090] text-[1px]  ml-[88px] mt-1">已發送</p>
                </div>
            </div> -->


            <!-- button -->
            <div class=" flex flex-col  items-center mt-2 ">

                <button
                    class="hover:scale-105 flex justify-center items-center  w-40 h-9 mt-3 rounded-[5px] text-center text-white bg-gradient-to-r from-[#6EA627] to-[#96C659]  font-semibold "
                    type="button">重 設 密 碼</button>
            </div>




        </div>
        <!-- 背景 -->
        <div class="backk absolute top-0 left-0">
        </div>
    </div>
</template>

<style lang="scss" scoped>
.backk {
    background: (linear-gradient(125deg, rgba(#5A8C00, .5) 20%, transparent 100%), linear-gradient(-125deg, rgba(#54F9EF, .5), transparent 40%));
    width: 100vw;
    height: 100vh;

}
</style>
