    <template>

      <footer class="footer footer-default">
      <div class="container">
        <div class="copyright" id="copyright">
          <p>Copyright &#169; 2024 Team Charlie </p>
        </div>
      </div>

    </footer>


    </template>
    


    <script>
    export default {
    
    }
    </script>
    


    <style>

body {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}

footer {
  margin-top: auto;
}
    
.footer {
  padding: 24px 0;
  bottom: 0;
  position: relative;
  width: 100%;
}

.footer.footer-default {
  background-color: #f2f2f2;
}

.footer nav {
  display: inline-block;
  float: left;
}

.footer ul {
  margin-bottom: 0;
  padding: 0;
  list-style: none;
}

.footer ul li {
  display: inline-block;
}

.footer ul li a {
  color: inherit;
  padding: 0.5rem;
  font-size: 0.8571em;
  text-transform: uppercase;
  text-decoration: none;
}

.footer ul li a:hover {
  text-decoration: none;
}

.footer .copyright {
  font-size: 0.8571em;
}

.footer:after {
  display: table;
  clear: both;
  content: " ";
}

.page-header footer {
  position: absolute;
  bottom: 0;
  width: 100%;
}
.footer .copyright {
    text-align: right;
  }
  



    </style>