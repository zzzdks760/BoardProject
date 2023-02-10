<template>
    <div>
        <input
        
        />
        <button @click="q">asa</button>
    </div>
</template>

<script>
import { BoardStore } from "@/store/store"
export default {
    setup() {
        const read = BoardStore.state
        return {
            read,
        }
    },
    methods: {
        q() {
            console.log(this.read)
        }
    },
}
</script>