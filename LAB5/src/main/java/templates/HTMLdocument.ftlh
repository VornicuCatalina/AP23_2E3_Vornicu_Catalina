<html>
  <body>
    <h1>Catalog ${name}</h1>
    <#assign seq=docs>
    <h2>The documents are:
    <#list seq?chunk(4) as row>
      <#list row as cell>${cell} </#list>
    </#list>
    </h2>
  </body>
</html>