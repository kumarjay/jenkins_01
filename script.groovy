def defFunc(){
  echo "This is groovey ${params.VERSION}"
}
def defBuild(){
  echo "This is inside build with version ${params.VERSION1}"
}

return this
