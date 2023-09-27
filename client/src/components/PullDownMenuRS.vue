<script>
export default{
    
}

</script>

<template>
    <!-- 下拉選單 -->
<div class="menu">
    <!-- 編輯留言 -->
    <div>
        <h5>編輯留言</h5>
    </div>

    <!-- 刪除留言 -->
    <div>
        <h5>刪除留言</h5>
    </div>

    <!-- 檢舉留言 -->
    <div>
        <h5>檢舉留言</h5>
    </div>


</div>
    

</template>

<style lang="scss" scoped>
.menu{ 
    position: absolute;
    top: 5px;
    right: 3px;
    background-color: white;
    width: 60px;
    height: 100px;
    z-index: 4;
    div{
        text-align: center;
        &:hover{
            h5{
                background-color: rgb(169, 168, 168);
                cursor: pointer;
            }
            
        }
        h5{
            font-size: 10px;
            background-color: white;
        }
    }
}



</style>

