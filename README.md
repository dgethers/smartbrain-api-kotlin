## Micronaut 3.0.0 Documentation

- [User Guide](https://docs.micronaut.io/3.0.0/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.0.0/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.0.0/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

ResultSet
model: id: "f76196b43bbd45c99b4f3cd8e8b40a8a"
name: "Face"
created_at {
seconds: 1606323024
nanos: 453038000
}
app_id: "main"
output_info {
output_config {
}
message: "Show output_info with: GET /models/{model_id}/output_info"
type: "detect-concept"
type_ext: "detect-concept"
fields_map {
fields {
key: "regions[...].data.concepts[...].id"
value {
string_value: "predicted_det_labels"
}
}
fields {
key: "regions[...].data.concepts[...].value"
value {
string_value: "predicted_det_scores"
}
}
fields {
key: "regions[...].region_info.bounding_box"
value {
string_value: "predicted_det_bboxes"
}
}
}
params {
fields {
key: "detection_threshold"
value {
number_value: 0.9
}
}
}
}
model_version {
id: "45fb9a671625463fa646c3523a3087d5"
created_at {
seconds: 1614879626
nanos: 81729000
}
status {
code: MODEL_TRAINED
description: "Model is trained and ready"
}
visibility {
gettable: PUBLIC
}
app_id: "main"
user_id: "clarifai"
metadata {
}
}
user_id: "clarifai"
input_info {
fields_map {
fields {
key: "image"
value {
string_value: "images"
}
}
}
}
train_info {
}
model_type_id: "visual-detector"
visibility {
gettable: PUBLIC
}
metadata {
}
modified_at {
seconds: 1606323024
nanos: 453038000
}

model: id: "3ed1aff251be4fe59c2bbaff0bb2e797"
name: "margin-110"
created_at {
seconds: 1590505298
nanos: 387731000
}
app_id: "main"
output_info {
output_config {
}
message: "Show output_info with: GET /models/{model_id}/output_info"
type: "image-crop"
type_ext: "image-crop"
params {
fields {
key: "margin"
value {
number_value: 1.1
}
}
}
}
model_version {
id: "b9987421b40a46649566826ef9325303"
created_at {
seconds: 1590505298
nanos: 387731000
}
status {
code: MODEL_TRAINED
description: "Model is trained and ready"
}
visibility {
gettable: PUBLIC
}
app_id: "main"
user_id: "clarifai"
metadata {
}
}
user_id: "clarifai"
input_info {
}
train_info {
}
model_type_id: "image-crop"
visibility {
gettable: PUBLIC
}
metadata {
}
modified_at {
seconds: 1590505298
nanos: 387731000
}

model: id: "93c277ec3940fba661491fda4d3ccfa0"
name: "appearance-multicultural"
created_at {
seconds: 1594664970
nanos: 251137000
}
app_id: "main"
output_info {
output_config {
}
message: "Show output_info with: GET /models/{model_id}/output_info"
type: "concept"
type_ext: "concept"
fields_map {
fields {
key: "concepts"
value {
string_value: "softmax"
}
}
}
}
model_version {
id: "b2897edbda314615856039fb0c489796"
created_at {
seconds: 1595271252
nanos: 737304000
}
status {
code: MODEL_TRAINED
description: "Model successfully uploaded and is now ready for inferencing"
}
visibility {
gettable: PUBLIC
}
app_id: "main"
user_id: "clarifai"
metadata {
}
}
display_name: "Multicultural Appearance"
user_id: "clarifai"
input_info {
fields_map {
fields {
key: "image"
value {
string_value: "images"
}
}
}
}
train_info {
}
model_type_id: "visual-classifier"
visibility {
gettable: PUBLIC
}
metadata {
}
modified_at {
seconds: 1595271252
nanos: 735610000
}

new region
bounding box: {clarifai.api.BoundingBox.top_row=0.26823992, clarifai.api.BoundingBox.left_col=0.29569015, clarifai.api.BoundingBox.bottom_row=0.4272996, clarifai.api.BoundingBox.right_col=0.37969133}
concept name: Black with values: 0.7101128
concept name: Latino_Hispanic with values: 0.24533622
concept name: Indian with values: 0.020117505
concept name: White with values: 0.008692207
concept name: Southeast Asian with values: 0.0074455063
concept name: Middle Eastern with values: 0.0071719736
concept name: East Asian with values: 0.0011237556
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.32424936, clarifai.api.BoundingBox.left_col=0.6694018, clarifai.api.BoundingBox.bottom_row=0.51452535, clarifai.api.BoundingBox.right_col=0.766134}
concept name: Black with values: 0.99976
concept name: Latino_Hispanic with values: 1.2193415E-4
concept name: Indian with values: 6.468702E-5
concept name: Southeast Asian with values: 4.106298E-5
concept name: White with values: 7.3637243E-6
concept name: Middle Eastern with values: 2.5381942E-6
concept name: East Asian with values: 2.404182E-6
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.19110726, clarifai.api.BoundingBox.left_col=0.7720753, clarifai.api.BoundingBox.bottom_row=0.41233194, clarifai.api.BoundingBox.right_col=0.88574684}
concept name: Black with values: 0.9992974
concept name: Indian with values: 3.1014247E-4
concept name: Latino_Hispanic with values: 2.7986374E-4
concept name: Southeast Asian with values: 5.4264052E-5
concept name: Middle Eastern with values: 2.9241257E-5
concept name: White with values: 2.5448431E-5
concept name: East Asian with values: 3.637851E-6
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.17328367, clarifai.api.BoundingBox.left_col=0.5491215, clarifai.api.BoundingBox.bottom_row=0.37938654, clarifai.api.BoundingBox.right_col=0.6476204}
concept name: White with values: 0.5859528
concept name: Latino_Hispanic with values: 0.25898337
concept name: Black with values: 0.08101855
concept name: Middle Eastern with values: 0.06388991
concept name: Indian with values: 0.0071313344
concept name: Southeast Asian with values: 0.0017805821
concept name: East Asian with values: 0.0012434497
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.078264065, clarifai.api.BoundingBox.left_col=0.15325432, clarifai.api.BoundingBox.bottom_row=0.28411907, clarifai.api.BoundingBox.right_col=0.25556907}
concept name: Black with values: 0.43281057
concept name: Latino_Hispanic with values: 0.39797035
concept name: Middle Eastern with values: 0.11205243
concept name: White with values: 0.045248903
concept name: Indian with values: 0.00998066
concept name: Southeast Asian with values: 0.0016693622
concept name: East Asian with values: 2.6775824E-4
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.1405251, clarifai.api.BoundingBox.left_col=0.43965435, clarifai.api.BoundingBox.bottom_row=0.32451332, clarifai.api.BoundingBox.right_col=0.5257409}
concept name: Black with values: 0.66084594
concept name: Latino_Hispanic with values: 0.25529405
concept name: Indian with values: 0.06024936
concept name: White with values: 0.017880397
concept name: Southeast Asian with values: 0.0030163797
concept name: Middle Eastern with values: 0.0020849751
concept name: East Asian with values: 6.2893523E-4
model: id: "af40a692dfe6040f23ca656f4e144fc2"
name: "appearance-gender"
created_at {
seconds: 1594663171
nanos: 633958000
}
app_id: "main"
output_info {
output_config {
}
message: "Show output_info with: GET /models/{model_id}/output_info"
type: "concept"
type_ext: "concept"
fields_map {
fields {
key: "concepts"
value {
string_value: "softmax"
}
}
}
}
model_version {
id: "ff83d5baac004aafbe6b372ffa6f8227"
created_at {
seconds: 1595271929
nanos: 698518000
}
status {
code: MODEL_TRAINED
description: "Model successfully uploaded and is now ready for inferencing"
}
visibility {
gettable: PUBLIC
}
app_id: "main"
user_id: "clarifai"
metadata {
}
}
display_name: "Gender Appearance"
user_id: "clarifai"
input_info {
fields_map {
fields {
key: "image"
value {
string_value: "images"
}
}
}
}
train_info {
}
model_type_id: "visual-classifier"
visibility {
gettable: PUBLIC
}
metadata {
}
modified_at {
seconds: 1595271929
nanos: 697428000
}

new region
bounding box: {clarifai.api.BoundingBox.top_row=0.26823992, clarifai.api.BoundingBox.left_col=0.29569015, clarifai.api.BoundingBox.bottom_row=0.4272996, clarifai.api.BoundingBox.right_col=0.37969133}
concept name: Masculine with values: 0.99934465
concept name: Feminine with values: 6.553105E-4
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.32424936, clarifai.api.BoundingBox.left_col=0.6694018, clarifai.api.BoundingBox.bottom_row=0.51452535, clarifai.api.BoundingBox.right_col=0.766134}
concept name: Feminine with values: 0.97361696
concept name: Masculine with values: 0.02638302
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.19110726, clarifai.api.BoundingBox.left_col=0.7720753, clarifai.api.BoundingBox.bottom_row=0.41233194, clarifai.api.BoundingBox.right_col=0.88574684}
concept name: Masculine with values: 0.99955493
concept name: Feminine with values: 4.4504783E-4
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.17328367, clarifai.api.BoundingBox.left_col=0.5491215, clarifai.api.BoundingBox.bottom_row=0.37938654, clarifai.api.BoundingBox.right_col=0.6476204}
concept name: Feminine with values: 0.9999696
concept name: Masculine with values: 3.0399837E-5
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.078264065, clarifai.api.BoundingBox.left_col=0.15325432, clarifai.api.BoundingBox.bottom_row=0.28411907, clarifai.api.BoundingBox.right_col=0.25556907}
concept name: Masculine with values: 0.99997556
concept name: Feminine with values: 2.4405119E-5
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.1405251, clarifai.api.BoundingBox.left_col=0.43965435, clarifai.api.BoundingBox.bottom_row=0.32451332, clarifai.api.BoundingBox.right_col=0.5257409}
concept name: Feminine with values: 0.99998677
concept name: Masculine with values: 1.32735895E-5
model: id: "36f90889189ad96c516d134bc713004d"
name: "appearance-age"
created_at {
seconds: 1594653568
nanos: 115015000
}
app_id: "main"
output_info {
output_config {
}
message: "Show output_info with: GET /models/{model_id}/output_info"
type: "concept"
type_ext: "concept"
fields_map {
fields {
key: "concepts"
value {
string_value: "softmax"
}
}
}
}
model_version {
id: "fb9f10339ac14e23b8e960e74984401b"
created_at {
seconds: 1595271576
nanos: 517193000
}
status {
code: MODEL_TRAINED
description: "Model successfully uploaded and is now ready for inferencing"
}
visibility {
gettable: PUBLIC
}
app_id: "main"
user_id: "clarifai"
metadata {
}
}
display_name: "Age Appearance"
user_id: "clarifai"
input_info {
fields_map {
fields {
key: "image"
value {
string_value: "images"
}
}
}
}
train_info {
}
model_type_id: "visual-classifier"
visibility {
gettable: PUBLIC
}
metadata {
}
modified_at {
seconds: 1595271576
nanos: 515877000
}

new region
bounding box: {clarifai.api.BoundingBox.top_row=0.26823992, clarifai.api.BoundingBox.left_col=0.29569015, clarifai.api.BoundingBox.bottom_row=0.4272996, clarifai.api.BoundingBox.right_col=0.37969133}
concept name: 3-9 with values: 0.82580936
concept name: 10-19 with values: 0.17398863
concept name: 20-29 with values: 1.2625939E-4
concept name: 0-2 with values: 6.647091E-5
concept name: 30-39 with values: 7.568904E-6
concept name: 40-49 with values: 1.4286446E-6
concept name: 50-59 with values: 1.9191714E-7
concept name: 60-69 with values: 8.3785956E-8
concept name: more than 70 with values: 8.76165E-9
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.32424936, clarifai.api.BoundingBox.left_col=0.6694018, clarifai.api.BoundingBox.bottom_row=0.51452535, clarifai.api.BoundingBox.right_col=0.766134}
concept name: 3-9 with values: 0.9204308
concept name: 10-19 with values: 0.07886251
concept name: 0-2 with values: 6.066014E-4
concept name: 20-29 with values: 8.939073E-5
concept name: 30-39 with values: 8.8357165E-6
concept name: 40-49 with values: 1.5836431E-6
concept name: 50-59 with values: 1.8319172E-7
concept name: 60-69 with values: 3.2075057E-8
concept name: more than 70 with values: 1.9793789E-9
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.19110726, clarifai.api.BoundingBox.left_col=0.7720753, clarifai.api.BoundingBox.bottom_row=0.41233194, clarifai.api.BoundingBox.right_col=0.88574684}
concept name: 50-59 with values: 0.54012907
concept name: 60-69 with values: 0.22782943
concept name: 40-49 with values: 0.18920057
concept name: 30-39 with values: 0.031701595
concept name: more than 70 with values: 0.008915955
concept name: 20-29 with values: 0.0020157113
concept name: 10-19 with values: 1.8525698E-4
concept name: 3-9 with values: 1.8626242E-5
concept name: 0-2 with values: 3.8537737E-6
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.17328367, clarifai.api.BoundingBox.left_col=0.5491215, clarifai.api.BoundingBox.bottom_row=0.37938654, clarifai.api.BoundingBox.right_col=0.6476204}
concept name: 50-59 with values: 0.5934219
concept name: 60-69 with values: 0.19885264
concept name: 40-49 with values: 0.18536602
concept name: 30-39 with values: 0.016988963
concept name: more than 70 with values: 0.004251651
concept name: 20-29 with values: 9.699612E-4
concept name: 10-19 with values: 9.394621E-5
concept name: 3-9 with values: 4.75705E-5
concept name: 0-2 with values: 7.3533924E-6
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.078264065, clarifai.api.BoundingBox.left_col=0.15325432, clarifai.api.BoundingBox.bottom_row=0.28411907, clarifai.api.BoundingBox.right_col=0.25556907}
concept name: 30-39 with values: 0.6098276
concept name: 40-49 with values: 0.30816093
concept name: 20-29 with values: 0.06538615
concept name: 50-59 with values: 0.014286524
concept name: 10-19 with values: 0.001914262
concept name: 60-69 with values: 3.5163536E-4
concept name: 3-9 with values: 7.049501E-5
concept name: more than 70 with values: 2.002276E-6
concept name: 0-2 with values: 4.602043E-7
new region
bounding box: {clarifai.api.BoundingBox.top_row=0.1405251, clarifai.api.BoundingBox.left_col=0.43965435, clarifai.api.BoundingBox.bottom_row=0.32451332, clarifai.api.BoundingBox.right_col=0.5257409}
concept name: 30-39 with values: 0.62751013
concept name: 20-29 with values: 0.2765799
concept name: 40-49 with values: 0.09312769
concept name: 10-19 with values: 0.0015491358
concept name: 50-59 with values: 0.0012232194
concept name: 60-69 with values: 7.024807E-6
concept name: 3-9 with values: 2.8110096E-6
concept name: 0-2 with values: 8.9973156E-8
concept name: more than 70 with values: 5.535826E-8
