    <template>

      <footer class="footer footer-default">
      <div class="container">
        <nav>
          <ul>
            <li>
              <a href="contact">
                <p><svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 640 512"><path d="M192 48c0-26.5 21.5-48 48-48L400 0c26.5 0 48 21.5 48 48l0 464-80 0 0-80c0-26.5-21.5-48-48-48s-48 21.5-48 48l0 80-80 0 0-464zM48 96l112 0 0 416L48 512c-26.5 0-48-21.5-48-48L0 320l80 0c8.8 0 16-7.2 16-16s-7.2-16-16-16L0 288l0-64 80 0c8.8 0 16-7.2 16-16s-7.2-16-16-16L0 192l0-48c0-26.5 21.5-48 48-48zm544 0c26.5 0 48 21.5 48 48l0 48-80 0c-8.8 0-16 7.2-16 16s7.2 16 16 16l80 0 0 64-80 0c-8.8 0-16 7.2-16 16s7.2 16 16 16l80 0 0 144c0 26.5-21.5 48-48 48l-112 0 0-416 112 0zM312 64c-8.8 0-16 7.2-16 16l0 24-24 0c-8.8 0-16 7.2-16 16l0 16c0 8.8 7.2 16 16 16l24 0 0 24c0 8.8 7.2 16 16 16l16 0c8.8 0 16-7.2 16-16l0-24 24 0c8.8 0 16-7.2 16-16l0-16c0-8.8-7.2-16-16-16l-24 0 0-24c0-8.8-7.2-16-16-16l-16 0z"/></svg></p>
                Contact Us
              </a>
            </li>
          </ul>
        </nav>
        <div class="copyright" id="copyright">
          <p>Copyright &#169; 2024 Team Charlie</p>
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

.copyright {
  height: auto;
  justify-content: right;
  color: green;
  right: 50px;
}

footer {
  margin-top: auto;
}
    
.footer {
  position: relative;
  display: flex;
  justify-content: flex-end;
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
