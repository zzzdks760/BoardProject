<template>
    <header class="header">
        <h1 class="logo">
            <span class="blind">logo</span>
        </h1>
        <div class="time_date">
        <span class="header_date">{{ timestamp }}</span>
        </div>
    </header>
</template>

<script>
import getDate from "../assets/common/getDate.js";

export default {
    data() {
        return {
            timestamp: ""
        }
    },
    created() {
        this.timestamp = `${getDate().month}/${getDate().date} ${getDate().week}`;
    }
}
</script>

<style>
.header {

}
.header_date {
    padding-right: 20px;
}
.time_date {
    text-align: right;
}
</style>