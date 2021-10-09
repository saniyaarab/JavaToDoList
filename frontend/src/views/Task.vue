<template>
  <div class="task">
    <ul>
        <li v-for="(item, index) in items" v-bind:key="index">{{item.description}}</li>
    </ul>
  </div>
  <button class="btn btn-danger btn-sm" @click="deleteTask">Delete</button>

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
  },
  methods: {
    deleteTask() {
        fetch("/api/messages/delete", {
            method: 'DELETE'})
            .then((response) => console.log(response))
    }
  }
}
</script>
