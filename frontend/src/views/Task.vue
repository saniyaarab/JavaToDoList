<template>
  <div class="task">
    <ul>
        <li v-for="(item, index) in items" v-bind:key="index">{{item.description}}</li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'Task',
  data() {
    return {
      items: []
    }
  },
  mounted() {
    fetch("/api/messages/test")
      .then((response) => response.json())
      .then((data) => {
          this.items = data;
      });
  }
}
</script>
