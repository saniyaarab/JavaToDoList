<template>
  <div class="task">
    <h1>{{msg}}</h1>
  </div>
</template>

<script>
export default {
  name: 'Task',
  data() {
    return {
      msg: ''
    }
  },
  mounted() {
    fetch("/api/messages/test")
      .then((response) => response.text())
      .then((data) => {
          this.msg = data;
      });
  }
}
</script>
