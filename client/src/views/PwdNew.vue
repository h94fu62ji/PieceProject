<script >
export default {

}
</script>

<template>
    <div>
        <!-- main -->
        <div class="main absolute">
            <!-- LOGO -->
            <div class="pt-32 flex justify-center items-center">

                <img class="flex w-32 h-32" src="../../public/logo.png" alt="">

            </div>
            <!-- 口號 -->
            <p class=" mt-2 flex justify-center items-center text-[#5A7A22] tracking-[7px] text-[1px] font-semibold">成為我們的一塊
            </p>
            <!-- 輸入新密碼 -->
            <div class="flex flex-col  items-center mt-2 ">

                <input
                    class="  focus:outline-[#90a073]  w-[500px] h-[40px] rounded-[5px] shadow-[inset_0px_1px_1px_rgba(0,0,0,0.3)] pl-[6px] "
                    type="text" placeholder="輸入新密碼">
                <p class=" flex  text-[1px]  ml-[420px] mt-1 text-red-600">規則不符</p>
            </div>


            <!-- button -->
            <div class=" flex flex-col  items-center mt-2 ">

                <button
                    class=" hover:scale-105 flex justify-center items-center  w-40 h-9 mt-3 rounded-[5px] text-center text-white bg-gradient-to-r from-[#6EA627] to-[#96C659]  font-semibold "
                    type="button">確　　認</button>
            </div>



        </div>
        <!-- 背景 -->
        <div class="backk">
        </div>
    </div>
</template>

<style lang="scss" scoped>
.backk {
    background: (linear-gradient(125deg, rgba(#5A8C00, .5) 20%, transparent 100%), linear-gradient(-125deg, rgba(#54F9EF, .5), transparent 40%));
    width: 100vw;
    height: 100vh;

}

.main {
    margin-left: 30%;
}
</style>
